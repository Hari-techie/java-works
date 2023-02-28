public class TestToy  {
    public static void main(String[] args) {
        Toy toys[] = new Toy[6];
		toys[0] = new Toy(101,"ABC","CAT","SM","RED","PLASTIC","CHENNAI",345.56,"13/DEC/2020");
		toys[1] = new Toy(103,"PQ","TALKING TOM","XL","GREY","COTTON","CBE",156.00,"03/DEC/2020");
		toys[2] = new Toy(101,"RS","REMOTE CAR","SM","BLACK","PLASTIC","CHENNAI",450.00,"11/OCT/2020");
		toys[3] = new Toy(101,"ABC","TRAIN","XL","RED","PLASTIC","CHENNAI",745.67,"15/DEC/2020");
		toys[4] = new Toy(105,"RS","CAT","LG","RED","COTTON","KARUR",230,"25/NOV/2020");
        toys[5] = new Toy(107,"ABC","DOG","XL","BLUE","COTTON","CBE",658.89,"24/DEC/2020");
		/*System.out.println("Available purchase list : ");
        displayAllToys(toys);
        System.out.println("------------Highest price of the toy : ----------------");
        findHighestPriceOfToy(toys);
        System.out.println("------------Lowest price of the toy : -----------------");
        findLowestPriceOfToy(toys);
        System.out.println("--------------Highest Selling Brand-----------------");
        findHighSellingBrand(toys);
        System.out.println("---------------Lowest Selling Brand --------------------");

        findLeastSellingBrand(toys);
        System.out.println("--------------Highest Selling Location--------------");
        findHighestSellingLocation(toys);
        System.out.println("-----------------Lowest Selling location-----------------");
        findLeastSellingLocation(toys);
        System.out.println("----------------Highly Preferred colour------------------");
        findHighPurchasedColour(toys);
        System.out.println("------------------Highly Purchased size-----------------");
        findHighPurchasedSize(toys);
        System.out.println("--------------Most visited customer in a month------------------");
        findMostVisitedCustomerInMonth(toys,"DEC");
        System.out.println("---------------Average price of a customer in a month------------");
        findAveragePriceOfACustomerInMonth(toys, "DEC");
        System.out.println("---------------Update price of a toy name : ------------------");
        updatePriceOfToy(toys, "TRAIN",350.00); */
        System.out.println(toys[0].toString());
        System.out.println(toys[0].getClass());
        System.out.println(toys[0].hashCode());
        
    }
    
    public static void updatePriceOfToy(Toy toys[],String reqName,double updatePrice)
    {
        int i;
        for(i=0;i<toys.length;i++)
        {
            if(toys[i].name.equals(reqName))
            {
                toys[i].price = updatePrice;
                break;
            }
        }
        toys[i].display();
    }
    public static void findAveragePriceOfACustomerInMonth(Toy toys[],String requiredMonth)
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0;
        double sumPrice = 0;
        for(i=0;i<n-1;i++)
        {
            count = 1;
            if(toysCopy[i]!=null && toysCopy[i].date.substring(3, 6).equals(requiredMonth))
            {
                sumPrice = toysCopy[i].price;
                for(j=i+1;j<n;j++)
                {
                     if(toysCopy[j]!=null && toysCopy[i].customerId == toysCopy[j].customerId && 
                     toysCopy[j].date.substring(3,6).equals(requiredMonth))
                     {
                         sumPrice = sumPrice + toysCopy[j].price;
                         toysCopy[j] = null;
                         count++;
                     }
                }
                if(toysCopy[i]!=null && toysCopy[i].date.substring(3, 6).equals(requiredMonth))
                {
                     System.out.println("Customer id : "+toysCopy[i].customerId+" Average price in "+requiredMonth+" month is "+(sumPrice/count));
                }
           }
        }
    }
    public static void findMostVisitedCustomerInMonth(Toy toys[],String requiredMonth)
    {
        Toy toysCopy[] = toys.clone();
        int mostVisitCust=0,i,j,n=toysCopy.length,count=0,mx=0;
        String month1 = "",month2 = "";
        for(i=0;i<n-1;i++)
        {
            count = 1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].customerId==toysCopy[j].customerId && toysCopy[i].date.substring(3,6).equals(requiredMonth) && toysCopy[i].date.substring(3,6).equals(toysCopy[j].date.substring(3,6)))
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count>mx)
            {
                mx = count;
                mostVisitCust = toysCopy[i].customerId;
            }
        }
        System.out.println("most visited customer in "+requiredMonth+" is : "+mostVisitCust);
    }
    public static void findHighPurchasedSize(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,maxCount=-1;
        String maxSize="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].size==toysCopy[j].size)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count>maxCount)
            {
                maxCount = count;
                maxSize = toysCopy[i].size;
            }
        }
        System.out.println("Maximum selling SIZE : "+maxSize);
    }
    public static void findHighPurchasedColour(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,maxCount=-1;
        String maxColour="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].colour==toysCopy[j].colour)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count>maxCount)
            {
                maxCount = count;
                maxColour = toysCopy[i].colour;
            }
        }
        System.out.println("Maximum selling colour : "+maxColour);
    }
    public static void findHighestSellingLocation(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,maxCount=-1;
        String maxLocation="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].location==toysCopy[j].location)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count>maxCount)
            {
                maxCount = count;
                maxLocation = toysCopy[i].location;
            }
        }
        System.out.println("Maximum selling location : "+maxLocation);
    }
    public static void findLeastSellingLocation(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,minCount=Integer.MAX_VALUE;
        String minLocation="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].location==toysCopy[j].location)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count<minCount)
            {
                minCount = count;
                minLocation = toysCopy[i].location;
            }
        }
        System.out.println("Maximum selling location : "+minLocation);
    }
    public static void findHighestPriceOfToy(Toy toys[])
    {
        double maxValue = 0;
        int maxValueIndex = -1;
        for(int i=0;i<toys.length;i++)
        {
            if(toys[i].price>maxValue)
            {
                maxValue = toys[i].price;
                maxValueIndex = i;
            }
        }
        toys[maxValueIndex].display();
    }
    public static void findHighSellingBrand(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,maxCount=-1;
        String maxBrand="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].brand==toysCopy[j].brand)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count>maxCount)
            {
                maxCount = count;
                maxBrand = toysCopy[i].brand;
            }
        }
        System.out.println("Maximum selling brand : "+maxBrand);
    }
    public static void findLeastSellingBrand(Toy toys[])
    {
        Toy toysCopy[] = toys.clone();
        int i,j,n=toysCopy.length,count=0,minCount=Integer.MAX_VALUE;
        String minBrand="";
        for(i=0;i<n-1;i++)
        {
            count=1;
            for(j=i+1;j<n;j++)
            {
                if(toysCopy[i]!=null && toysCopy[j]!=null && toysCopy[i].brand==toysCopy[j].brand)
                {
                    count++;
                    toysCopy[j]=null;
                }
            }
            if(toysCopy[i]!=null && count<minCount)
            {
                minCount = count;
                minBrand = toysCopy[i].brand;
            }
        }
        System.out.println("Minimum selling brand : "+minBrand);
    }
    public static void findLowestPriceOfToy(Toy toys[])
    {
        double minValue = Double.MAX_VALUE;
        int minValueIndex = -1;
        for(int i=0;i<toys.length;i++)
        {
            if(toys[i].price<minValue)
            {
                minValue = toys[i].price;
                minValueIndex = i;
            }
        }
        toys[minValueIndex].display();
    }
    public static void displayAllToys(Toy toys[])
    {
        for(int i=0;i<toys.length;i++)
        {
            if(toys!=null)
            {
                toys[i].display();
            }
            else
            {
                System.out.println("null");
            }
        }
    }
}
