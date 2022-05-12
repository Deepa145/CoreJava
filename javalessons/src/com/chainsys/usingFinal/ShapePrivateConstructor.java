package com.chainsys.usingFinal;

public class ShapePrivateConstructor {
public int height;
public int width;
private ShapePrivateConstructor()
{
	System.out.println("ShapeA CreatedA"+hashCode());
	}
private ShapePrivateConstructor(int x)
{
height=x;
width=x;
System.out.println(x+"ShapeA CreatedB"+hashCode());
}
public static ShapePrivateConstructor getObject()//factory method
{
return new ShapePrivateConstructor();//call to private constructor	
}
public static void testPrivateConstructor() {
	ShapePrivateConstructor refShapeA=
			ShapePrivateConstructor.getObject();
	refShapeA.height=123;
	refShapeA.width=500;
	refShapeA.echo();
}
private void echo() {
	// TODO Auto-generated method stub
	
}


}
