function b = float2bin(number,dec_length)
    wholeb='';
    decimalb='.';
    whole=floor(number);
    dec=mod(number,1);
    while whole>1
        wholeb(end+1)=num2str(mod(whole,2));
        whole=floor(whole/2);
    end
    wholeb(end+1)=num2str(whole);
    for i=(1:dec_length)
        if dec < power(2,-i)
            decimalb(end+1)='0';
        else
            decimalb(end+1)='1';
            dec=dec-power(2,-i);
        end
    end
    while ~isempty(decimalb) && decimalb(end) ~='1'
        decimalb(end)='';
    end
    b=char(append(string(fliplr(wholeb)),decimalb));
end