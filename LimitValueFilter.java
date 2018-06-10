

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import beans.LimitValue;

/**
 * Servlet Filter implementation class LimitValueFilter
 */
public class LimitValueFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LimitValueFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//何かの動作ごとに指値を確認して処理するフィルタ
		//むっちゃ重そう
		List<LimitValue> limitList= new ArrayList<LimitValue>();
		//limitList = LimitValue.InputFile();

		//RateLogの取得
		List<RateLog> logList= new ArrayList<RateLog>();
		//logList = RateLog.InputFile();


		//現在の売値より低い指値ID、買値より高い指値USERIDがあったら処理する。
		//指値から消す？




		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
