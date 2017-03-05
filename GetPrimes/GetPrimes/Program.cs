using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GetPrimes
{
    class Program
    {
        static void Main(string[] args)
        {
            string end = "";
            while (!end.Equals("n") && !end.Equals("N")) {
                Console.WriteLine("Enter the number primes you want:");

                uint entered = UInt32.Parse(Console.ReadLine());
                GetPrimes(entered);
                //ArrayList answer = GetPrimes(entered);
                //foreach (var n in answer)
                //{
                //    Console.WriteLine(n);
                //}
                Console.WriteLine("Enter N to quit or anything else to factor more primes");
                end = Console.ReadLine();
            }
        }


        static ArrayList GetPrimes(uint numberOfPrimes)
        {
            ArrayList temp = new ArrayList();
            temp.Add(1);
            uint count = 3;
            while (temp.Count < numberOfPrimes)
            {
                if (PrimeTest(count))
                {
                    Console.WriteLine(count);
                    temp.Add(count);
                }
                count++;
            }
            return temp;
        }

        static bool PrimeTest(uint number)
        {
            bool isPrime = false;
            uint testNumber = 2;
            while (testNumber < number)
            {
                if (number % testNumber != 0) ;
                else { break; }

                testNumber++;
            }

            if (testNumber == number) isPrime = true;

            return isPrime;
        }
    }
}
