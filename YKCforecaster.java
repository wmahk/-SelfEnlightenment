import java.math.BigDecimal;
import java.util.List;

public class YKCforecaster {

	//変動予測クラス


	//単回帰分析
	public static BigDecimal calcCoefficient(List<RateLog> logList) {
		BigDecimal a = new BigDecimal("0");//戻り値(係数a)

		BigDecimal conv = new BigDecimal("0"); //共分散
		double varX = 0; //xの分散

		int L = logList.size();


		//平均X~の計算
		double tmp = 0;
		for(int i=0;i<L;i++){
			tmp = tmp + i;
		}
		double meanX = tmp / L;



		//Xの分散の計算
		for(int i=0;i<L;i++) {
			varX = varX + Math.pow((i - meanX), 2);
		}
		varX = varX / L;


		//平均Y~の計算
		BigDecimal tmpB = new BigDecimal("0");
		for(int i=0;i<L;i++) {
			RateLog nowLog = logList.get(i);
			tmpB = tmpB.add(nowLog.getRate());
		}
		BigDecimal meanY = tmpB.divide(new BigDecimal(L));


		//共分散の算出(BigDecimal型で計算を頑張る)
		BigDecimal Xpart;
		BigDecimal Ypart;
		BigDecimal mulResult;
		for(int i=0;i<L;i++) {
			Xpart = new BigDecimal(i);
			Xpart = Xpart.subtract(new BigDecimal(meanX));

			RateLog nowLog = logList.get(i);
			Ypart = nowLog.getRate();
			Ypart = Ypart.subtract(meanY);

			mulResult = Xpart.multiply(Ypart);

			conv = conv.add(mulResult);
		}
		conv = conv.divide(new BigDecimal(L));


		a = conv.divide(new BigDecimal(varX),2, BigDecimal.ROUND_HALF_UP);



		return a;

	}


	//2点間平均変化量
	//平均変化量を算出する
	//予め渡すListは半日毎とかに間引かないと求めている変化量が出ない(トランザクション毎は好ましくない)
	public static BigDecimal calcFluctuationRange(List<RateLog> logList) {

		BigDecimal meanRange = new BigDecimal("0");

		int L = logList.size();

		for(int i=0;i<L-1;i++) {//2点比較のためL-1まで

			RateLog nowLog = logList.get(i);
			RateLog nextLog = logList.get(i+1);

			BigDecimal nowValue = (nowLog.getRate()).subtract(nextLog.getRate());

			nowValue = nowValue.abs();//絶対値処理

			meanRange = meanRange.add(nowValue);


		}

		meanRange = meanRange.divide(new BigDecimal(L-1),2, BigDecimal.ROUND_HALF_UP);


		return meanRange;
	}
}
