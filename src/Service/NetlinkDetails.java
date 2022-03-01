package Service;

import java.util.ArrayList;

import Dao.NetlinkDao;
import Model.Netlink;

public class NetlinkDetails {
	NetlinkDao NetDao = new NetlinkDao();
	ArrayList<Netlink> NetList = new ArrayList<>();
	public void AddNetlink(Netlink netlink) throws ClassNotFoundException {
		NetList.add(netlink);
		NetDao.storeNetRecord(NetList);
	}

}
