#时间控制
##导入依赖
    <dependency>
        <groupId>org.apache.velocity</groupId>
        <artifactId>velocity-engine-core</artifactId>
        <version>2.0</version>
    </dependency>
##代码
    @Component
    public class MyHandler implements MetaObjectHandler {
        @Override
        public void insertFill(MetaObject metaObject) {
            System.out.println("添加插入时间");
            this.setFieldValByName("gmtCreate",new Date(),metaObject);//gmtCreate与实体类字段一致 
            this.setFieldValByName("gmtModified",new Date(),metaObject);
        }
    
        @Override
        public void updateFill(MetaObject metaObject) {
            System.out.println("添加更新时间");
            this.setFieldValByName("gmtModified",new Date(),metaObject);
        }
    }    