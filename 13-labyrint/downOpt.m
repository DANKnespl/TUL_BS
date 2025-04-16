function opt=downOpt(num)
upFree=[0,2,3,4,6,7,8,14];
upFull=[1,5,9,10,11,12,13,15];
switch(num)
    case 0
        opt=upFree;
    case 1
        opt=upFree;
    case 2
        opt=upFull;
    case 3
        opt=upFree;
    case 4
       opt=upFree;
    case 5
        opt=upFull;
    case 6
        opt=upFree;
    case 7
        opt=upFull;
    case 8
       opt=upFull;
    case 9
        opt=upFree;
    case 10
        opt=upFree;
    case 11
        opt=upFull;
    case 12
        opt=upFree;
    case 13
        opt=upFull;
    case 14
        opt=upFull;
    case 15
        opt=upFull;
    otherwise
        opt=0;

end
end