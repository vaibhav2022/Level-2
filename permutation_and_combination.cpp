#include<bits/stdc++.h>
using namespace std;

int infinite_per(vector<int> &arr, int tar, int n, string psf){

    if(tar == 0){
        cout<< psf << endl;
        return 1;
    }

    int count = 0;
    for(int i=0; i<n; i++){
        if(tar >= arr[i]){
            count += infinite_per(arr, tar-arr[i], n, psf + to_string(arr[i]));
        }
    }
    return count;
}

int infinite_com(vector<int> &arr, int idx, int tar, int n, string psf){
    if(tar == 0){
        cout << psf << endl;
        return 1;
    }
    int count = 0;
    for(int i=idx; i<n; i++){
        if(tar >= arr[i]){
            count += infinite_com(arr, i, tar-arr[i], n, psf + to_string(arr[i]));
        }
    }
    return count;
}

void infinite(){
    int n = 4;
    vector<int> arr = {2, 3, 5, 7};
    int tar = 10;
    // cout << infinite_per(arr, tar, n, "") << endl;
    cout << infinite_com(arr,0 , tar, n, "") << endl;
}

int main(){
    infinite();
}
