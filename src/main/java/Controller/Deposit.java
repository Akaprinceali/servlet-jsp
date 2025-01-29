package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;

@WebServlet("/deposit")
public class Deposit extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String amt = req.getParameter("amnt");
		
		double amount = Double.parseDouble(amt);
		
		Long acno= (Long) req.getSession().getAttribute("acc_number");
		
		BankDao bankDao = new BankDao();
		
		
		Bank_account bank_account = bankDao.find(acno);
		
		bank_account.setAmount(bank_account.getAmount()+amount);
		
		bankDao.update_the_details(bank_account);
		
		res.getWriter().print("<h1>Amount deposited successfully</h1>");
		
	}
}
