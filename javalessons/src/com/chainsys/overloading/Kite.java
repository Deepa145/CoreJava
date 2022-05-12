package com.chainsys.overloading;

public class Kite {
	void fly (int distance)
    {
        System.out.println("Fly 1 "+distance);
    }
    void fly (double time, int speed)
    {
        System.out.println("Fly 1 "+time);
    }
    int fly(int time, int speed)
    {
        return time*speed;
    }
    void fall(String time)
    {
        System.out.println("Fall "+time);
    }
    int fall(int distance)
    {
        System.out.println("Fall 2"+distance);
        return distance;
    }
    void glide(int time)
    {
        
    }
	
}
