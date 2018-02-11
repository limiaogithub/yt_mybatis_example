package com.github.yt.example.excel;


import com.github.yt.excel.util.EncodeUtils;
import com.github.yt.excel.util.ExcelUtils;
import com.github.yt.excel.vo.ExcelConfig;
import com.github.yt.web.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/excel")
public class TestExcelController extends BaseController {

    @ApiOperation(value = "export")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export() throws Exception {
        ServletOutputStream out = response.getOutputStream();
        String fileName = EncodeUtils.toUtf8String(request.getHeader("User-Agent"), "导出文件.xls");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setContentType("application/octet-stream; charset=utf-8");
        ExcelUtils.createExcel(out, TestBean.class, getTestList());
        out.flush();
    }

    @ApiOperation(value = "import")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public void import1(@RequestParam("file") MultipartFile file) throws Exception {
        List<TestBean> list = ExcelUtils.readExcel(file, TestBean.class, new ExcelConfig().setStartRow(2));
        System.out.println(list.size());
        for (TestBean testBean : list) {
            System.out.println(testBean.toString());
        }
    }

    private static List<TestBean> getTestList() {
        List<TestBean> list = new ArrayList<>();
        TestBean testBean1 = new TestBean("name1", 123, new Date(), new BigDecimal(1111));
        list.add(testBean1);
        TestBean testBean2 = new TestBean("name2", 456, new Date(), new BigDecimal(2222));
        list.add(testBean2);
        return list;
    }

}
