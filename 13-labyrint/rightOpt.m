function opt=rightOpt(num)
leftFree=[0,1,2,3,5,7,10,11];
leftFull=[4,6,8,9,12,13,14,15];
switch(num)
    case 0
        opt=leftFree;
    case 1
        opt=leftFree;
    case 2
        opt=leftFree;
    case 3
        opt=leftFull;
    case 4
        opt=leftFree;
    case 5
        opt=leftFree;
    case 6
        opt=leftFull;
    case 7
        opt=leftFull;
    case 8
        opt=leftFree;
    case 9
        opt=leftFree;
    case 10
        opt=leftFull;
    case 11
        opt=leftFull;
    case 12
        opt=leftFull;
    case 13
        opt=leftFree;
    case 14
        opt=leftFull;
    case 15
        opt=leftFull;
    otherwise
        opt=0;

end
end