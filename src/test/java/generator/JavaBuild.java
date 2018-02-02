package generator;


import com.github.yt.generator.JavaCodeGenerator;


public class JavaBuild {


    @org.testng.annotations.Test
    public void test() {

        JavaCodeGenerator generator = new JavaCodeGenerator(
                "root",
                "1234",
                "antdpro",
                "jdbc:mysql://localhost:3307/antdpro");

        String tableName = "OrderT";
        String codeName = "订单";
        String moduleName = "订单";
        String modulePackage = "com.github.yt.example.order";
        generator.create(tableName, codeName, moduleName, modulePackage
                //  , "html"
                , "bean"
                , "controller"
                , "service"
                , "mapper"
                , "mapper_xml"
        );
    }

}