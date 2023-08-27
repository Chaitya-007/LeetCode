class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int dist_from_origin = 0;
        int lft_cnt = count(moves.begin(),moves.end(),'L');
        int rght_cnt = count(moves.begin(),moves.end(),'R'); 
        int flag = 1;
        
        
           for(int i = 0 ; i < moves.length() ; i++)
        {
           
                if(moves[i] == '_')
            {
                
               
                    if(lft_cnt <= rght_cnt)
                    {
                        
                    dist_from_origin = dist_from_origin + 1;
                    
                    }                        
                    else 
                    { 
                        
                    dist_from_origin = dist_from_origin - 1;  
                        
                    }
                    
            }
            
             if(moves[i] == 'L')
            {
                dist_from_origin = dist_from_origin - 1;
            }
            
             if(moves[i] == 'R')
            {
                dist_from_origin = dist_from_origin + 1;
            } 
             
        }  
        
        
        return abs(dist_from_origin);
        
        
    }
};