package gc_assignment;

import java.util.Arrays;

/*
 * Student First Name:
 * Student Last Name:
 * Student BU Number:
 * Purpose: 
 */

public class Set  {
    private static final int SIZE = 10; // default size of initial set
                                
    private int[] set;      // array referece to the set
    private int size;       // current size of the set
    private int next;       // index to next available slot in the set array
    
    
    public Set() {
        // your code here
    	this.set=new int[SIZE];
    }
 
	public Set(int[] arr) {
		// your code here
		// check size if the size is > SIZE then use grow method else copy the elements
		// of arr to set
		if (arr.length > size) {
			this.set = grow(arr);
			size = this.set.length;
			next = size;
		} else {
			if (size != 0) {
				for (int i = 0; i < arr.length; i++) {
					this.set[i] = arr[i];
				}
				size = this.set.length;
				next = size;
			}
		}
	}
    
    private int[] grow(int[] arr) {
    	Arrays.sort(arr);
//    	removeDuplicates
    	arr=removeDuplicates(arr);
		return arr;
	}

    private int[] removeDuplicates(int[] arr) {
    	int n= arr.length;
    	int temp[] = new int [n];
    	int j = 0;
    	for(int i= 0; i<n-1;i++) {
    		if(arr[i]!=arr[i+1]) {
    			temp[j++]=arr[i];
    		}
    	}
    	temp[j++] = arr[n-1];
    	for(int i=0;i<j;i++) {
    		arr[i]=temp[i];
    	}
		return arr;
	}

	public Set clone() {
        // your code here
		Set s1 = new Set();
		for(int i=0;i<size;i++)
			s1.insert(set[i]);
		return s1;
    }

    public void insert(int k) {
        // your code here
    	if(member(k) && size!=0)
    		return;
    	try {
    		this.set[next++]=k;
    		size=next;
    	}catch (ArrayIndexOutOfBoundsException e) {
    		resize();
    		this.set[--next]=k;
    		next++;
//    		size++;
		}
    }

    /** 
     * This method reallocates the array set to twice as 
     * big and copies all the elements over.
     * This method is called only by the insert method
     * when it cannot insert another element to the set.
     *
     * Note that this is the reason that in this class
     * the member size is not a class variable (i.e. static)
     * and it is not final, because the set can grow and size
     * will be modified accordingly.
     */
    
    private void resize() {
        size *= 2;

	// Create a new array double the size
        int[] temp = new int[size];

	// Copy all the elements from the current set
	// to the new set
        for(int i = 0; i < set.length; ++i) {
            temp[i] = set[i];
        }

	// Assign to the set reference the newly
	// resized array that represents the set.
        set = temp;
    }

//  Uncomment each method as you implement 
 
    public  String toString()  {
        // your code here
    	String s="";
    	if(size==0) {
    		s="["+"]";
    	}else {
    		s=s+"[";
    		for(int i=0;i<size-1;i++) {
    			s=s+this.set[i]+",";
    		}
    		s=s+this.set[size-1]+"]";
    	}
    	return s;
    } 
     
    public int cardinality() {
        // your code here
    	return size;
    }
    
    public  boolean isEmpty() {
        // your code here
    	return size==0?true:false;
    }
      
    public boolean member(int k) {
        // your code here
    	for(int i=0;i<this.set.length;i++) {
    		if(set[i]==k)
    			return true;
    	}
    	return false;
    }    
   
    public  boolean subset(Set S) {
        // your code here
    	if(size==0)
    		return true;
    	if(S.size==0)
    		return false;
    	if(size==0 && S.size==0)
    		return true;
    		
    	boolean isSubset=true;
    	
    	for(int i=0;i<this.set.length;i++) {
    		isSubset=S.member(set[i]);
    		if(!isSubset)
    			return false;
    	}
    	return isSubset;
    }
    
    public  boolean equal(Set S) {
        // your code here
    	if(S.size!=this.size) {
    		return false;
    	}else {
    		return subset(S);
    	}
    }
       
    public void delete(int k) {
        // your code here
    	if(!member(k))
    		return;
    	int index=getElementIndex(k);
    	for(int i=index;i<size;) {
			set[i]=set[++i];
		}
		size--;
    }
  
    private int getElementIndex(int k) {
    	for(int i=0;i<this.set.length;i++) {
    		if(set[i]==k)
    			return i;
    	}
		return -1;
	}

	public Set union(Set S) {
        // your code here
		if(size==0) {
			return S;
		}
		Set s1 = new Set(this.set);
		for(int i=0;i<S.size;i++) {
				s1.insert(S.set[i]);
		}
		return s1;
    }
   
    public Set intersection(Set S) {
        // your code here
    	Set s1 = new Set();
    	if(S.size>=this.set.length) {
    		for(int i=0;i<set.length;i++) {
    			if(S.member(this.set[i])) {
    				s1.insert(set[i]);
    			}
    		}
    	}else {
    		for(int i=0;i<S.size;i++) {
    			if(member(S.set[i])) {
    				s1.insert(set[i]);
    			}
    		}
    	}
		return s1;
    	
    }
    
    public Set setdifference(Set S) {
        // your code here
    	if(S.size==0){
    		return clone();
    	}
    	Set s1 = new Set();
    	if(S.size>=this.set.length) {
    		for(int i=0;i<set.length;i++) {
    			if(!S.member(this.set[i])) {
    				s1.insert(set[i]);
    			}
    		}
    	}else {
    		for(int i=0;i<S.size;i++) {
    			if(!member(S.set[i])) {
    				s1.insert(set[i]);
    			}
    		}
    	}
		return s1;
    }

}
