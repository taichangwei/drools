package indi.taicw.drools.entity;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StudentTest {

    @Test
    public void testInnerMethod(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student = new Student();
        student.setAge(5);

        kieSession.insert(student);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_student_age"));

        kieSession.dispose();
    }

}
