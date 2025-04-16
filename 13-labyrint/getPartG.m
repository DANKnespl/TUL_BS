function [partG] = getPartG(part)
    
L0=[255 255 255 255 255;...
     255 255 255 255 255;...
     255 255 255 255 255;...
     255 255 255 255 255;...
     255 255 255 255 255];   
 L1=[255 255 0 255 255;...
     255 255 0 255 255;...
     255 255 128 255 255;...
     255 255 255 255 255;...
     255 255 255 255 255];
 L2=[255 255 0 255 255;...
     255 255 0 255 255;...
     255 255 0 255 255;...
     255 255 0 255 255;...
     255 255 0 255 255];
 L3=[255 255 0 255 255;...
     255 255 0 255 255;...
     255 255 0 0 0;...
     255 255 255 255 255;...
     255 255 255 255 255];
 L4=[255 255 0 255 255;...
     255 255 0 255 255;...
     0 0 0 0 0;...
     255 255 255 255 255;...
     255 255 255 255 255];
 L5=[255 255 0 255 255;...
     255 255 0 255 255;...
     0 0 0 0 0;...
     255 255 0 255 255;...
     255 255 0 255 255];

 
 
    %1=L1;
    %2=imrotate(L1,180);
    %3=imrotate(L1,-90);
    %4=imrotate(L1,90);
    %5=L2;
    %6=imrotate(L2,90);
    %7=imrotate(L3,-90);
    %8=imrotate(L3,180);
    %9=imrotate(L3,90);
    %10=L3;
    %11=imrotate(L4,-90);
    %12=L4;
    %13=imrotate(L4,90);
    %14=imrotate(L4,180);
 switch(part)
     case 0
         partG=L0;
     case 1
         partG=L1;
     case 2
         partG=imrotate(L1,180);
     case 3
         partG=imrotate(L1,-90);
     case 4
         partG=imrotate(L1,90);
     case 5
         partG=L2;
     case 6
         partG=imrotate(L2,90);
     case 7
         partG=imrotate(L3,-90);
     case 8
         partG=imrotate(L3,180);
     case 9
         partG=imrotate(L3,90);
     case 10
         partG=L3;
     case 11
         partG=imrotate(L4,-90);
     case 12
         partG=L4;
     case 13
         partG=imrotate(L4,90);
     case 14
         partG=imrotate(L4,180);
     case 15
         partG=L5;
end

