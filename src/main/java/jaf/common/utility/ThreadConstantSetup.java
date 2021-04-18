package jaf.common.utility;

import org.constants.variables.ThreadConstants;

public final class ThreadConstantSetup {

	private ThreadConstantSetup() {} // to stop user from extending or creating the instance of the class
	private final static ThreadLocal<ThreadConstants> THREAD_CONST = new ThreadLocal<ThreadConstants>();  
	public static void initThreadPool(){
		
		THREAD_CONST.set(new ThreadConstants());
		
	}
	public static ThreadConstants get() {
		return THREAD_CONST.get();
	}	
}
