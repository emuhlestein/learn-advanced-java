import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.function.Consumer;

public class ConsumerLambdaExample {
    public static void main(String[] args) {
        Consumer<String> c = (String s) -> {System.out.println(s);};

        c.accept("Dude");

        // Can be simplified
        Consumer<String> c1 = s -> System.out.printf(s);

        c1.accept("Another Dude");
    }
}
