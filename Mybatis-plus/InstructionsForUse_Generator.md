# mybatis-plus逆向工程使用说明

##1.导入依赖：    
        <dependency>
          <groupId>org.apache.velocity</groupId>
          <artifactId>velocity-engine-core</artifactId>
          <version>2.0</version>
        </dependency>
    
        <dependency>
          <groupId>com.baomidou</groupId>
          <artifactId>mybatis-plus-generator</artifactId>
          <version>3.4.1</version>
        </dependency>

##2.生成代码
    public static void main(String[] args) {
            // 构建一个代码生成对象
            AutoGenerator mpg = new AutoGenerator();
    
            // 1. 全局配置
            GlobalConfig gc = new GlobalConfig();
    
            String separator = File.separator;
            gc.setOutputDir("D:\\github\\xinrui-seckill\\xinrui-seckill-v1\\src\\main\\java");
            gc.setAuthor("作者");//设置作者
            gc.setOpen(false);//打开目录
            gc.setFileOverride(true);//是否覆盖
            gc.setServiceName("%sService");//去Service的I前缀。
            gc.setIdType(IdType.ID_WORKER);
            gc.setDateType(DateType.ONLY_DATE);
            gc.setSwagger2(false);
    
            mpg.setGlobalConfig(gc);
    
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://localhost:3306/xinrui_seckill?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
            dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql 8.x版本为：com.mysql.cj.jdbc.Driver
            dsc.setUsername("root");
            dsc.setPassword("root");
            dsc.setDbType(DbType.MYSQL);
    
            mpg.setDataSource(dsc);
    
            // 包设置
            PackageConfig pc = new PackageConfig();
    
            pc.setParent("com.xinrui");
            pc.setEntity("entity");
            pc.setMapper("mapper");
            pc.setController("controller");
    
            mpg.setPackageInfo(pc);
    
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setInclude("seckill_item");    //表名
            strategy.setNaming(NamingStrategy.underline_to_camel);  // 下划线转驼峰
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);    // 列 下划线转驼峰
            strategy.setEntityLombokModel(true);    //是否开启lombok
            strategy.setLogicDeleteFieldName("deleted");
    
            // 自动填充
            TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);   
            TableFill gmtModified = new TableFill("gmt_modified",FieldFill.INSERT_UPDATE); 
            ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
            tableFills.add(gmtCreate);
            tableFills.add(gmtModified);
    
            strategy.setTableFillList(tableFills);
    
            //乐观锁
            strategy.setVersionFieldName("version");
    
            // restcontroller
            strategy.setRestControllerStyle(true);
            strategy.setControllerMappingHyphenStyle(true);// localhost:xxx/hello_2
    
            mpg.setStrategy(strategy);
    
            mpg.execute();
        }

 




        