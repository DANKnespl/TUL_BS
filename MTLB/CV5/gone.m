function gone(n,r)
    if (nargin==1)
        r=1;
    end
    a=0:n;
    if (n>=3 && r>0)
        switch mod(n,2)
            case 0
                c=cosd(360/n*a)*r;
                s=sind(360/n*a)*r;
                plot([c],[s]);
            case 1
                c=cosd(360/n*a+90)*r;
                s=sind(360/n*a+90)*r;
                plot([c],[s]);
        end
        axis equal;
        axis padded;
    else
        disp('ErR0r, zadané hodnoty nejsou validní');
    end
end