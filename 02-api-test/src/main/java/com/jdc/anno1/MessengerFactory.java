package com.jdc.anno1;

import com.jdc.annos.Message;
import com.jdc.annos.Messages;

public class MessengerFactory {
	
	@Messages({
		@Message("Hello"),
		@Message("Annotation as type")
	})
	private String msg;
}
