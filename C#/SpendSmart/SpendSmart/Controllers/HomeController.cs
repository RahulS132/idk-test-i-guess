using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using SpendSmart.Models;

namespace SpendSmart.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        private readonly SpendSmartDbContext _context;//database context for accessing expenses

        public HomeController(ILogger<HomeController> logger, SpendSmartDbContext context)//constructor to initialize logger and database context
        {
            _logger = logger;
            _context = context;
        }

        public IActionResult Index()//action to display the home page
        {
            return View();
        }

        public IActionResult Expenses()//action to display the list of expenses
        {
            var allExpenses = _context.Expenses.ToList(); //retrieving all expenses from the database

            var totalExpenses =  allExpenses.Sum(x => x.Value); //calculating the total value of expenses
            ViewBag.Expenses = totalExpenses; //passing the total expenses to the view using ViewBag
            return View(allExpenses);
        }

        public IActionResult CreateEditExpense(int? id)//action to display the form for creating or editing an expense
        {
            if (id != null)
            {
                //editing -> load an expense by id
                var expenseInDb = _context.Expenses.SingleOrDefault(expense => expense.Id == id);
                return View(expenseInDb);
            }
            return View();
        }

        public IActionResult CreateEditExpenseForm(Expense model)// action to handle the form submission for creating or editing an expense 
        {
            if(model.Id == 0)
            {
                //create
                _context.Expenses.Add(model);
            } else
            {
                //Editing
                _context.Expenses.Update(model);
            }
                _context.SaveChanges(); //saving the changes to the database
                return RedirectToAction("Expenses");
        }
        public IActionResult DeleteExpense(int id)
        {
            var expenseInDb = _context.Expenses.SingleOrDefault(expense => expense.Id == id);
            _context.Expenses.Remove(expenseInDb);
            _context.SaveChanges();
            return RedirectToAction("Expenses");
        }
        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
