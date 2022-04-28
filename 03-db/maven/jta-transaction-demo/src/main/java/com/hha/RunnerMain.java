package com.hha;


import com.hha.db.service.WareHouseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class RunnerMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(RunnerMain.class);
        context.registerShutdownHook();


        WareHouseService wareHouseService=context.getBean(WareHouseService.class);
        wareHouseService.purgeData();

        try{
            wareHouseService.saveData();
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() +" exception caught");
        }


        wareHouseService.listAllData();
    }
}
