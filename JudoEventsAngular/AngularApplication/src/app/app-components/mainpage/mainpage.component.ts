import {Component, ElementRef, OnInit} from '@angular/core';
import 'lightslider';

declare let $:any;


@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  private slider: any = null;
  constructor(private elemntRef: ElementRef) {

  }

  ngOnInit() {
    this.slider = $(this.elemntRef.nativeElement).find('#light-slider');

    this.slider.lightSlider({
      item:1 ,
      loop:false,
      slideMove:1,
      easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
      speed:1500,
      auto:true,
      pause: 15000,
      controls:true,
      mode:"slide",
      enableTouch:true,
      enableDrag:false,
      pager:true,

      responsive : [
        {
          breakpoint:800,
          settings: {
            item:1,
            slideMove:1,
            slideMargin:6,
          }
        },
        {
          breakpoint:480,
          settings: {
            item:1,
            slideMove:1
          }
        }
      ]
    })
  }



}
