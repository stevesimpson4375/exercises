using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using System.ComponentModel;
using Breeze.Sharp;
using Todo.Models;

namespace BreezeTest
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        public event PropertyChangedEventHandler PropertyChanged;

        // Bindable property
        public IEnumerable<TodoItem> Items
        {
            get { return _items; }
            set
            {
                _items = value;
                if (PropertyChanged != null)
                {
                    PropertyChanged(this, new PropertyChangedEventArgs("Items"));
                }
            }
        }
        private IEnumerable<TodoItem> _items;

        public override async void BeginInit()
        {
            base.BeginInit();

            DataContext = this;

            Configuration.Instance.ProbeAssemblies(typeof(TodoItem).Assembly);

            // Create an EntityManager
            var entityManager = new EntityManager("http://sampleservice.breezejs.com/api/todos/");

            // Allow use of a partial model of server entities
            entityManager.MetadataStore.AllowedMetadataMismatchTypes = MetadataMismatchTypes.AllAllowable;

            // Query all TodoItems from the IdeaBlade-supplied public service
            Items = await QueryTodosFrom(entityManager);
        }

        private async Task<IEnumerable<TodoItem>> QueryTodosFrom(EntityManager entityManager)
        {
            try
            {
                return await new EntityQuery<TodoItem>().Execute(entityManager);
            }
            catch (Exception e)
            {
                MessageBox.Show(e.GetType().Name + ": " + e.Message);
                return new TodoItem[0];
            }
        }
    }
}