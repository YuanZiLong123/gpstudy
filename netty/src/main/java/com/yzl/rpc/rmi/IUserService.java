package com.yzl.rpc.rmi;

import com.yzl.rpc.SerizableDome.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/10/30
 */
public interface IUserService  extends Remote {



     User getUser() throws RemoteException;

}
