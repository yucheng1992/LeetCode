/*
 * =====================================================================================
 *
 *       Filename:  reverseString.cpp
 *
 *    Description:  CC150
 *
 *        Version:  1.0
 *        Created:  04/03/2015 20:40:04
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  LYC
 *   Organization:  
 *
 * =====================================================================================
 */

#include<iostream>
using namespace std;

void reverse(char* str) {
    char* end = str;
    char temp;
    if (str) {
        while (*end) {
            end++;
        }
        end--;
        while (str < end) {
            temp = *str;
            *str++ = *end;
            *end-- = temp;
        }
    }
}
