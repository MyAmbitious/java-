package com.alex.command;
/*
命令模式（Command Pattern）：在软件设计中，我们经常需要
向某些对象发送请求，但是并不知道请求的接收者是谁，也不知
道被请求的操作是哪个，
我们只需在程序运行时指定具体的请求接收者即可，此时，可以
使用命令模式来进行设计
2) 命名模式使得请求发送者与请求接收者消除彼此之间的耦合，让
对象之间的调用关系更加灵活，实现解耦。
3) 在命名模式中，会将一个请求封装为一个对象，以便使用不同参
数来表示不同的请求(即命名)，同时命令模式也支持可撤销的操作。
4) 通俗易懂的理解：将军发布命令，士兵去执行。其中有几个角色：
将军（命令发布者）、士兵（命令的具体执行者）、命令(连接将
军和士兵)。



将发起请求的对象与执行请求的对象解耦。发起请求的对象是调用者，调用者只要
调用命令对象的execute()方法就可以让接收者工作，而不必知道具体的接收者对
象是谁、是如何实现的，命令对象会负责让接收者执行请求的动作，也就是说：”
请求发起者”和“请求执行者”之间的解耦是通过命令对象实现的，命令对象起到
了纽带桥梁的作用。
2) 容易设计一个命令队列。只要把命令对象放到列队，就可以多线程的执行命令
3) 容易实现对请求的撤销和重做
4) 命令模式不足：可能导致某些系统有过多的具体命令类，增加了系统的复杂度，这
点在在使用的时候要注意
5) 空命令也是一种设计模式，它为我们省去了判空的操作。在上面的实例中，如果没
有用空命令，我们每按下一个按键都要判空，这给我们编码带来一定的麻烦。
6) 命令模式经典的应用场景：界面的一个按钮都是一条命令、模拟CMD（DOS命令） 订单的撤销/恢复、触发-反馈机制
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//使用命令设计模式，完成通过遥控器，对电灯的操作
		
		//创建电灯的对象(接受者)
		LightReceiver lightReceiver = new LightReceiver();
		
		//创建电灯相关的开关命令
		LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
		LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
		
		//需要一个遥控器
		RemoteController remoteController = new RemoteController();
		
		//给我们的遥控器设置命令, 比如 no = 0 是电灯的开和关的操作
		remoteController.setCommand(0, lightOnCommand, lightOffCommand);
		
		System.out.println("--------按下灯的开按钮-----------");
		remoteController.onButtonWasPushed(0);
		System.out.println("--------按下灯的关按钮-----------");
		remoteController.offButtonWasPushed(0);
		System.out.println("--------按下撤销按钮-----------");
		remoteController.undoButtonWasPushed();
		
		
		System.out.println("=========使用遥控器操作电视机==========");
		
		TVReceiver tvReceiver = new TVReceiver();
		
		TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
		TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
		
		//给我们的遥控器设置命令, 比如 no = 1 是电视机的开和关的操作
		remoteController.setCommand(1, tvOnCommand, tvOffCommand);
		
		System.out.println("--------按下电视机的开按钮-----------");
		remoteController.onButtonWasPushed(1);
		System.out.println("--------按下电视机的关按钮-----------");
		remoteController.offButtonWasPushed(1);
		System.out.println("--------按下撤销按钮-----------");
		remoteController.undoButtonWasPushed();

	}

}
