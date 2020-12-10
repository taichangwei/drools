package indi.taicw.drools.entity;

import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class ComparisonOperatorTest {

    //测试比较操作符
    @Test
    public void testComparisonOperatorRule(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        ComparisonOperator comparisonOperator = new ComparisonOperator();
        comparisonOperator.setNames("张三");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        comparisonOperator.setList(list);

        kieSession.insert(comparisonOperator);

        kieSession.fireAllRules();

        kieSession.dispose();
    }

    @Test
    public void testSpecificRule() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        ComparisonOperator comparisonOperator = new ComparisonOperator();
        comparisonOperator.setNames("张三");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        comparisonOperator.setList(list);

        kieSession.insert(comparisonOperator);

        //通过规则过滤器(AgendaFilter)实现只执行指定规则。
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_comparison_memberOf"));

        kieSession.dispose();
    }

}
