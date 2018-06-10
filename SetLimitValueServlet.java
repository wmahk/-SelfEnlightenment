

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LimitValue;

/**
 * Servlet implementation class SetLimitValueServlet
 */
public class SetLimitValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetLimitValueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String userID = (String) session.getAttribute("userID");

		BigDecimal limitSell = new BigDecimal((String)request.getParameter("limitSell"));
		BigDecimal limitBuy = new BigDecimal((String)request.getParameter("limitBuy"));
		BigDecimal sellValue = new BigDecimal((String)request.getParameter("sellValue"));
		BigDecimal buyValue = new BigDecimal((String)request.getParameter("buyValue"));



		List<LimitValue> limitList= new ArrayList<LimitValue>();
		//limitList = LimitValue.InputFile();


		//UIDに上書き保存するために古い情報は削除
		int count = 0;
		for(LimitValue tmp : limitList) {

			if(userID.equals(tmp.getUserID())) {
				limitList.remove(count);
				break;
			}
			count++;
		}

		//新規情報のセット&ファイル書き出し
		LimitValue newLimit = new LimitValue();
		newLimit.setUserID(userID);
		newLimit.setLimitBuy(limitBuy);
		newLimit.setLimitSell(limitSell);
		newLimit.setBuyValue(buyValue);
		newLimit.setSellValue(sellValue);
		limitList.add(newLimit);

		//LimitValue.OutputFile(limitList);
		request.getRequestDispatcher("").forward(request, response);



	}

}
