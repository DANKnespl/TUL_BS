function out = MyRound(value,type,decimals)
    if type==0
        out=ceil(value*10^decimals)/(10^decimals);
    else
        out=floor(value*10^decimals)/(10^decimals);
    end
end