/*
 * Copyright (c) 2020 Arm Limited and affiliates.
 * SPDX-License-Identifier: Apache-2.0
 */
#include "mbed.h"
#include "stm32746g_discovery_lcd.h"
#include <Callback.h>

DigitalOut led1(LED1);

Mutex stdio_mutex;
Thread thread;
Thread thread2;
Thread thread3;
struct vars{
        uint32_t BG_Colour=LCD_COLOR_BLACK;
        uint32_t TX_Colour=LCD_COLOR_ORANGE;
        uint32_t period = 1000; //ms
        int x = 0; 
        int y = 100; 
        char* txt=""; 
    };
    
    
    
    
void threading(struct vars* proms){
    while(true){
        stdio_mutex.lock();
            BSP_LCD_SetBackColor(proms->BG_Colour);
            BSP_LCD_SetTextColor(proms->TX_Colour);
            BSP_LCD_DisplayStringAt(proms->x,proms->y, (uint8_t *)(proms->txt), CENTER_MODE);
        stdio_mutex.unlock();
        ThisThread::sleep_for((proms->period)/2);
        stdio_mutex.lock();
            BSP_LCD_SetTextColor(BSP_LCD_GetBackColor());
            BSP_LCD_DisplayStringAt(proms->x, proms->y, (uint8_t *)(proms->txt), CENTER_MODE);
        stdio_mutex.unlock();
        ThisThread::sleep_for((proms->period)/2);
    }
}

void thr(){
    BSP_LCD_DisplayStringAt(0,20, (uint8_t *)"haha", CENTER_MODE);       
    ThisThread::sleep_for(1000);
    }
void thr2(){
    
    BSP_LCD_DisplayStringAt(0,100, (uint8_t *)"hihi", CENTER_MODE);           
    ThisThread::sleep_for(1000);
    }


int main()
{   
    BSP_LCD_Init();
    BSP_LCD_LayerDefaultInit(LTDC_ACTIVE_LAYER, LCD_FB_START_ADDRESS);
    BSP_LCD_SetFont(&LCD_DEFAULT_FONT);
    BSP_LCD_SelectLayer(LTDC_ACTIVE_LAYER);
    BSP_LCD_Clear(LCD_COLOR_BLACK);
    struct vars fml;
    fml.y=20;
    fml.txt="We are no";
    struct vars fml2;
    fml2.txt="strangers";
    fml2.period=2000;
    struct vars fml3;
    fml3.y=200;
    fml3.txt="to love";
    fml3.period=1500;
    thread.start(callback(threading,&fml));
    thread2.start(callback(threading,&fml2));
    thread3.start(callback(threading,&fml3));
    while (true) {    
    }
}
/*
int main()
{   
    BSP_LCD_Init();
    BSP_LCD_LayerDefaultInit(LTDC_ACTIVE_LAYER, LCD_FB_START_ADDRESS);
    BSP_LCD_SetFont(&LCD_DEFAULT_FONT);
    BSP_LCD_SelectLayer(LTDC_ACTIVE_LAYER);
    BSP_LCD_Clear(LCD_COLOR_BLACK);
    while (true) {    
    //thread.join(thr);
    BSP_LCD_Clear(LCD_COLOR_BLACK);
    ThisThread::sleep_for(1000);
    thread2.join(thr2);
    BSP_LCD_Clear(LCD_COLOR_BLACK);
    ThisThread::sleep_for(2000);
    
    }
}
*/