/**
 * 
 */
package de.schule.madnx.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author xgadscj
 *
 */
public interface GetMessageHandler extends EventHandler {
	void getMessage(GetMessageEvent event);
}