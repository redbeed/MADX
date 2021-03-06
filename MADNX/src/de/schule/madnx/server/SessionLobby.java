/**
 * 
 */
package de.schule.madnx.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.Session;

import de.schule.madnx.server.game.GamePlay;
import de.schule.madnx.shared.Methods;
import de.schule.madnx.shared.Option;
import de.schule.madnx.shared.User;

/**
 * @author xgadscj
 *
 */
public class SessionLobby {
	private ArrayList<Option> options;
	private ArrayList<User> players;
	private ArrayList<Session> lobby;
	private String host;
	private int size;
	private String status;
	private GamePlay gamePlay;

	private Logger logger = Logger.getLogger(SessionLobby.class.getName());

	public SessionLobby() {
		lobby = new ArrayList<>();
		options = new ArrayList<>();
		players = new ArrayList<>();

		loadOptions();
	}

	public void addToLobby(Session session, boolean host) {
		lobby.add(session);
		User player = new User();
		player.setHost(host);
		String user = session.getUserProperties().get(Methods.USER).toString();
		if (user.equals(host)) {
			player.setHost(true);
		}
		player.setName(user);
		player.setStatus(false);

		players.add(player);
	}

	public void removeFromLobby(Session session) {
		lobby.remove(session);

		String user = session.getUserProperties().get(Methods.USER).toString();
		User remove = null;
		for (User p : players) {
			if (p.getName().equals(user)) {
				remove = p;
			}
		}
		if (remove != null) {
			players.remove(remove);
		}
	}

	public void sendToAll(String message, Session session) {

		for (Session s : lobby) {
			if (!session.equals(s) && s.isOpen()) {
				try {
					s.getBasicRemote().sendText(message);
				} catch (IOException e) {
					logger.log(Level.SEVERE, "Chat-Error", e);
					e.printStackTrace();
				}
			}
		}
	}

	public void sendTo(String message, Session session) {
		for (Session s : lobby) {
			if (session.equals(s) && s.isOpen()) {
				try {
					s.getBasicRemote().sendText(message);
				} catch (IOException e) {
					logger.log(Level.SEVERE, "Chat-Error", e);
					e.printStackTrace();
				}
			}
		}
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public int getCurrentCount() {
		return 0;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return (int) lobby.get(0).getUserProperties().get("lobby");
	}

	public ArrayList<User> getPlayers() {
		return players;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public ArrayList<Session> getLobby() {
		return lobby;
	}

	private void loadOptions() {

	}

	public void setGamePlay(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	public GamePlay getGamePlay() {
		return gamePlay;
	}

}
