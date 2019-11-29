package com.alex.facade;
/*
外观模式（Facade），也叫“过程模式：外观模式为子系统中的一组接口提供
一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加
容易使用
2) 外观模式通过定义一个一致的接口，用以屏蔽内部子系统的细节，使得调用端
只需跟这个接口发生调用，而无需关心这个子系统的内部细节

外观模式对外屏蔽了子系统的细节，因此外观模式降低了客户端对子系统使用的复
杂性
2) 外观模式对客户端与子系统的耦合关系，让子系统内部的模块更易维护和扩展
3) 通过合理的使用外观模式，可以帮我们更好的划分访问的层次
4) 当系统需要进行分层设计时，可以考虑使用Facade模式
5) 在维护一个遗留的大型系统时，可能这个系统已经变得非常难以维护和扩展，此时
可以考虑为新系统开发一个Facade类，来提供遗留系统的比较清晰简单的接口，
让新系统与Facade类交互，提高复用性
6) 不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好。
要以让系统有层次，利于维护为目的。
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//这里直接调用。。 很麻烦
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		homeTheaterFacade.play();
		
		
		homeTheaterFacade.end();
	}

}