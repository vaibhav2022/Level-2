#include <bits/stdc++.h>

using namespace std;

vector<int> lead;

int findLead(int s)
{
    if(lead[s] == s) return s;
    
    return lead[s] = (findLead(lead[s]));
}

int main() {
    string s1, s2, baseString;
    cin>>s1 >> s2 >> baseString;
    
    lead.resize(26,0);
    
    
    string ans = "";
    
    for(int i=0; i<26;i++ ){
        lead[i] = i;
    }
    
    for(int i=0; i<s1.length(); i++)
    {
        int l1 = findLead(s1[i] - 'a');
        int l2 = findLead(s2[i] - 'a');
        
        if(l1!=l2)
        {
            if(l1 > l2)
            {
                lead[l1] = l2;
            }
            else{
                lead[l2] = l1;
            }
        }
    }
    
    for(int i=0; i<baseString.length(); i++)
    {
        int leader = findLead(baseString[i] - 'a');
        ans += char(leader + 'a');
    }
    cout<<ans;
}
