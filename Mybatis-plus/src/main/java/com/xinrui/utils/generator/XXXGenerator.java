package com.xinrui.utils.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;


public class XXXGenerator {
    public static void main(String[] args) {
        // 构建一个代码生成对象
        AutoGenerator mpg = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
//&1. Absolute Path
        String separator = File.separator;
        gc.setOutputDir("D:\\github\\Utils\\Mybatis-plus\\src\\main\\java");
        gc.setAuthor("作者");//设置作者
        gc.setOpen(false);//打开目录
        gc.setFileOverride(true);//是否覆盖
        gc.setServiceName("%sService");//去Service的I前缀。
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(false);

        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/Test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
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
        strategy.setInclude("user");    //表名
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);    // 列 下划线转驼峰
        strategy.setEntityLombokModel(true);    //是否开启lombok
        strategy.setLogicDeleteFieldName("deleted");

        // 自动填充
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);    //数据库必备字段
        TableFill gmtModified = new TableFill("gmt_modified",FieldFill.INSERT_UPDATE);  //数据库必备字段
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(gmtCreate);//创建时间
        tableFills.add(gmtModified);//修改时间

        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setVersionFieldName("version");

        // restcontroller
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);// localhost:xxx/hello_2

        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
