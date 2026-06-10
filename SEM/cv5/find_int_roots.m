function [x, M] = find_int_roots(p)
    mk1=[]; %vektor pro nutnou podmínku
    mk2=[]; %vektor pro omezenost kořenů
    x=[];
    ptmp=p;
    M(1,:)=ptmp;
    %nutná podmínka pro celočíselné kořeny
    r=0; %počet nul na konci polynomu
    while(p(end-r)==0)
        r=r+1;
        x(end+1)=0;
    end
    for(i=-abs(p(end-r)):abs(p(end-r)))
        if (mod(p(end-r),i)==0)
            mk1(end+1)=i; 
        end
    end
    sort(mk1);
    %omezenost kořenů
    for(i=1:length(mk1))
        if (mk1(i)<1+max(abs(mk1))/abs(p(1)))
            mk2(end+1)=mk1(i);
        end
    end
    i=1;
    sort(mk2);
    while(i<=length(mk2))
        b=0;
        for(j=1:length(p))
            b=b*mk2(i)+ptmp(j);
        end
        if (b==0)
            x(end+1)=mk2(i);
            ptmp=[deconv(ptmp,[1 -x(end)]) 0]; %"dlouhé dělení" 
            M(end+1,:)=ptmp;
        else
            i=i+1;
        end
    end
    x=transpose(x);
end