package action;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbpm.test.JBPMHelper;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import  org.kie.api.KieBaseConfiguration;
 import  org.kie.api.builder.KieBuilder;
 import  org.kie.api.builder.KieFileSystem;
 import  org.kie.api.builder.Message;
 import  org.kie.api.builder.Results;
 import  org.kie.api.builder.model.KieModuleModel;
 import  org.kie.api.conf.KieBaseOption;
 import  org.kie.api.io.Resource;
 import  org.kie.api.io.ResourceType;
 import java.lang.reflect.InvocationTargetException; 
 import java.lang.reflect.Method; 
 import java.util.ArrayList; 
 import java.util.List; 
 
  
 import javax.xml.bind.ValidationException; 
  
 import org.apache.log4j.Logger; 

 //import org.jboss.reddeer.eclipse.condition.MarkerIsUpdating; 
 
 import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;
public class SaveAction extends ActionSupport{

	public KieSession createKieSession() {
		
			
			KieHelper kieHelper = new KieHelper();
		
			
			Resource resource = ResourceFactory.newFileResource("sample.bpmn.hello");
				resource.setResourceType(ResourceType.BPMN2);
			resource.setSourcePath("sample.bpmn"); // it is not checked
			
			KieBase kieBase = kieHelper.addResource(resource).build();
			KieSession kSession = kieBase.newKieSession();
			
			
			
			return kSession;
	}
	public void execute2()
	{

		// RuntimeManager manager = createRuntimeManager(kieBase);
		//RuntimeEngine engine = manager.getRuntimeEngine(null);
	
	this.createKieSession().startProcess("sample.bpmn.hello");
	//KieSession ksession = engine.getKieSession();
		//ksession.startProcess("sample.bpmn.hello");

		//manager.disposeRuntimeEngine(engine);
		//System.exit(0);
	
	}
}

	/*private static RuntimeManager createRuntimeManager(KieBase kbase) {
		JBPMHelper.startH2Server();
		JBPMHelper.setupDataSource();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.persistence.jpa");
		RuntimeEnvironmentBuilder builder = RuntimeEnvironmentBuilder.Factory.get()
			.newDefaultBuilder().entityManagerFactory(emf)
			.knowledgeBase(kbase);
		return RuntimeManagerFactory.Factory.get()
			.newSingletonRuntimeManager(builder.get(), "com.sample:example:1.0");
	}*/



