package org.diosoft.spring.lesson5.spel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;
import java.util.Random;

class MainApp {

	public static void main(String[] args) {
		try {
			// ApplicationContext with XML
			AbstractApplicationContext context = new ClassPathXmlApplicationContext(
					"lesson5-spel-config.xml");

			// create subject and add default observer (user.name)
			Postman postman = context.getBean("postman", Postman.class);

			// send message 1
			System.out.println("-----------Send message 1");
			postman.notifyObservers(new Message("Hello1"));

			// load observers from properties
			postman.loadObserversFromProperties();
			// send message 2
			System.out.println("-----------Send message 2");
			postman.notifyObservers(new Message("Hello2"));

			// load observers from map's values
			ExpressionParser parser = new SpelExpressionParser();
			Map<String, String> myMap = (Map<String, String>) parser.parseExpression("{'first':'firstName','second':'secondName'}").getValue(context);
			postman.loadObserverByNames(myMap.values());
			// send message 3
			System.out.println("-----------Send message 3");
			postman.notifyObservers(new Message("Hello3"));

			// register function
			StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
			evaluationContext.registerFunction("generatedString", MainApp.class.getDeclaredMethod("generatedString"));
			// use function
			String randomName1 = parser.parseExpression("#generatedString()").getValue(evaluationContext, String.class);
			String randomName2 = parser.parseExpression("#generatedString()").getValue(evaluationContext, String.class);
			// load observers from random generatedString()
			postman.register(new Person(randomName1));
			postman.register(new Person(randomName2));
			// send message 4
			System.out.println("-----------Send message 4");
			postman.notifyObservers(new Message("Hello4"));
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

	static String generatedString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}
}
