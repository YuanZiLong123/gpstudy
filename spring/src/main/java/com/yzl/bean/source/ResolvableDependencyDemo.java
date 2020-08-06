package spring.bean.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author admin
 * @date 2020-08-06 9:29
 */
public class ResolvableDependencyDemo {

    @Autowired
    private String value;


    @PostConstruct
    public void printfValue(){
        System.out.println(111);
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(ResolvableDependencyDemo.class);

        /*annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory->{
            beanFactory.registerResolvableDependency(String.class, "hello word");
        });*/
        annotationConfigApplicationContext.addBeanFactoryPostProcessor( new BeanDealWith());

        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.close();

    }




}


class BeanDealWith implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerResolvableDependency(String.class, "hello word");
    }
}
