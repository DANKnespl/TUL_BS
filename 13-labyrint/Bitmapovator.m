function [bitmap] = Bitmapovator(map)
    s=size(map)
    bitmap=[];
    tmp=[];
    for x=1:s(1)
        for y=1:s(2)
            tmp=[tmp getPartG(map(x,y))];
        end
        bitmap=[bitmap;tmp];
        tmp=[];
    end
end