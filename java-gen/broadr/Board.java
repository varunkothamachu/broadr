package broadr;

import java.util.List;

import broadr.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table BOARD.
 */
public class Board {

    private Long id;
    private String name;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient BoardDao myDao;

    private List<Message> messages;

    public Board() {
    }

    public Board(Long id) {
        this.id = id;
    }

    public Board(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBoardDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<Message> getMessages() {
        if (messages == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MessageDao targetDao = daoSession.getMessageDao();
            List<Message> messagesNew = targetDao._queryBoard_Messages(id);
            synchronized (this) {
                if (messages == null) {
                    messages = messagesNew;
                }
            }
        }
        return messages;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetMessages() {
        messages = null;
    }

    /**
     * Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context.
     */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context.
     */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context.
     */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

}