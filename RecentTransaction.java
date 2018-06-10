import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import beans.TransactionLog;

public class RecentTransaction {

	//show recent transaction ...etc

	public RecentTransaction() {

	}

	public List<TransactionLog> showRecentTrans(String userID){
		//UserIDで絞った取引履歴を、呼び出し元で拡張forで対応

		List<TransactionLog> retList = new ArrayList<TransactionLog>();

		List<TransactionLog> TransList = new ArrayList<TransactionLog>();
		//		TransList = TransactionLog.InputFile();



		for(TransactionLog tmp : TransList) {

			if(userID.equals(tmp.getUserID())){
				retList.add(tmp);
			}

		}

		return retList;

	}


	public String showUserRank(String userID){
		//UserIDで絞った取引履歴からユーザーランクを計算

		String nowRank = null;

		List<TransactionLog> TransList = new ArrayList<TransactionLog>();
		//		TransList = TransactionLog.InputFile();

		BigDecimal totalTrans = new BigDecimal("0");



		for(TransactionLog tmp : TransList) {

			if(userID.equals(tmp.getUserID())){
				totalTrans = totalTrans.add(tmp.getPrice());
			}

		}


		//グレード情報と比較してランク決定、返却



		return nowRank;

	}





}
