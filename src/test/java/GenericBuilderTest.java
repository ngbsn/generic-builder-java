import org.greenfall.builder.ObjectBuilder;
import org.greenfall.model.ComplexObject;
import org.junit.Assert;
import org.junit.Test;

public class GenericBuilderTest {

    @Test
    public void testGenericObjectBuilder(){

        ComplexObject complexObject = ObjectBuilder.buildComplexObject("Hello World");
        Assert.assertEquals(complexObject.getNestedObjectA().getA(), "Hello World");
        Assert.assertEquals(complexObject.getNestedObjectB().getB(), "Hello World");
    }

    @Test
    public void testGenericObjectBuilderFail(){

        ComplexObject complexObject = ObjectBuilder.buildComplexObject("Hello World");
        Assert.assertNotEquals(complexObject.getNestedObjectA().getA(), "Hello Other World");
        Assert.assertNotEquals(complexObject.getNestedObjectB().getB(), "Hello Other World");
    }
}
