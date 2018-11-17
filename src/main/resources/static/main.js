(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/about/about.component.html":
/*!********************************************!*\
  !*** ./src/app/about/about.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"'What is sudoCode?'\"></app-header>\n  <div class=\"container\" style=\"max-width: 800px\">\n\n    <div class=\"bg\"></div>\n    <h2>\n      <strong>sudoCode</strong> is currently just a site for developers to share and get ideas for side projects.\n    </h2><br>\n\n\n    <p class=\"text-muted\">At least for now...</p>\n  </div>\n\n\n\n</div>\n"

/***/ }),

/***/ "./src/app/about/about.component.scss":
/*!********************************************!*\
  !*** ./src/app/about/about.component.scss ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".bg {\n  /* The image used */\n  background-image: url(\"/src/assets/java-bg-code.png\");\n  /* Full height */\n  height: 50%;\n  /* Center and scale the image nicely */\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: cover;\n  z-index: 9999; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL2Fib3V0L2Fib3V0LmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0JBQW9CO0VBQ3BCLHNEQUFxRDtFQUVyRCxpQkFBaUI7RUFDakIsWUFBVztFQUVYLHVDQUF1QztFQUN2Qyw0QkFBMkI7RUFDM0IsNkJBQTRCO0VBQzVCLHVCQUFzQjtFQUN0QixjQUFhLEVBQ2QiLCJmaWxlIjoic3JjL2FwcC9hYm91dC9hYm91dC5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi5iZyB7XG4gIC8qIFRoZSBpbWFnZSB1c2VkICovXG4gIGJhY2tncm91bmQtaW1hZ2U6IHVybChcIi9zcmMvYXNzZXRzL2phdmEtYmctY29kZS5wbmdcIik7XG5cbiAgLyogRnVsbCBoZWlnaHQgKi9cbiAgaGVpZ2h0OiA1MCU7XG5cbiAgLyogQ2VudGVyIGFuZCBzY2FsZSB0aGUgaW1hZ2UgbmljZWx5ICovXG4gIGJhY2tncm91bmQtcG9zaXRpb246IGNlbnRlcjtcbiAgYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcbiAgYmFja2dyb3VuZC1zaXplOiBjb3ZlcjtcbiAgei1pbmRleDogOTk5OTtcbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/about/about.component.ts":
/*!******************************************!*\
  !*** ./src/app/about/about.component.ts ***!
  \******************************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return AboutComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AboutComponent = /** @class */ (function () {
    function AboutComponent() {
    }
    AboutComponent.prototype.ngOnInit = function () {
    };
    AboutComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-about',
            template: __webpack_require__(/*! ./about.component.html */ "./src/app/about/about.component.html"),
            styles: [__webpack_require__(/*! ./about.component.scss */ "./src/app/about/about.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], AboutComponent);
    return AboutComponent;
}());



/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./project/project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
/* harmony import */ var _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./project/project-post/project-post.component */ "./src/app/project/project-post/project-post.component.ts");
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./project/project-detail/project-detail.component */ "./src/app/project/project-detail/project-detail.component.ts");
/* harmony import */ var _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./user/user-list/user-list.component */ "./src/app/user/user-list/user-list.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    {
        path: '',
        redirectTo: 'projects',
        pathMatch: 'full'
    },
    {
        path: 'projects',
        component: _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__["ProjectListComponent"],
        data: { title: 'Projects' }
    },
    {
        path: 'projects/post',
        component: _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_3__["ProjectPostComponent"],
        data: { title: 'New Project' }
    },
    {
        path: 'projects/:id',
        component: _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_5__["ProjectDetailComponent"],
        data: { title: 'Project Details' }
    },
    {
        path: 'users',
        component: _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_6__["UserListComponent"],
        data: { title: 'Users' }
    },
    {
        path: 'about',
        component: _about_about_component__WEBPACK_IMPORTED_MODULE_4__["AboutComponent"],
        data: { title: 'About' }
    },
    {
        path: '**',
        redirectTo: ''
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\" id=\"content\" style=\"padding: 0\">\n  <app-navbar></app-navbar>\n\n  <div id=\"sub-content\" class=\"bord max-width-wrapper container align-self-auto\">\n    <router-outlet></router-outlet>\n  </div>\n  <app-footer></app-footer>\n</div>\n"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".bg-img {\n  background-image: url(\"/src/assets/java-bg-code.png\");\n  -webkit-filter: blur(2px);\n          filter: blur(2px);\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: cover; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL2FwcC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHNEQUFxRDtFQUNyRCwwQkFBaUI7VUFBakIsa0JBQWlCO0VBQ2pCLDRCQUEyQjtFQUMzQiw2QkFBNEI7RUFDNUIsdUJBQXNCLEVBQ3ZCIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmJnLWltZyB7XG4gIGJhY2tncm91bmQtaW1hZ2U6IHVybChcIi9zcmMvYXNzZXRzL2phdmEtYmctY29kZS5wbmdcIik7XG4gIGZpbHRlcjogYmx1cigycHgpO1xuICBiYWNrZ3JvdW5kLXBvc2l0aW9uOiBjZW50ZXI7XG4gIGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XG4gIGJhY2tncm91bmQtc2l6ZTogY292ZXI7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AppComponent = /** @class */ (function () {
    function AppComponent(route, titleService, activatedRoute) {
        this.route = route;
        this.titleService = titleService;
        this.activatedRoute = activatedRoute;
        this.title = 'frontend';
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.events.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["filter"])(function (event) { return event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function () { return _this.activatedRoute; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (route) {
            while (route.firstChild) {
                route = route.firstChild;
            }
            return route;
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["filter"])(function (route) { return route.outlet === 'primary'; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["mergeMap"])(function (route) { return route.data; })).subscribe(function (event) { return _this.titleService.setTitle(event['title'] + ' - sudoCode'); });
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["Title"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: XhrInterceptor, AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "XhrInterceptor", function() { return XhrInterceptor; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./navbar/navbar.component */ "./src/app/navbar/navbar.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./project/project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
/* harmony import */ var _project_project_card_project_card_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./project/project-card/project-card.component */ "./src/app/project/project-card/project-card.component.ts");
/* harmony import */ var _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./project/project-post/project-post.component */ "./src/app/project/project-post/project-post.component.ts");
/* harmony import */ var _project_project_search_project_search_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./project/project-search/project-search.component */ "./src/app/project/project-search/project-search.component.ts");
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./header/header.component */ "./src/app/header/header.component.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./project/project-detail/project-detail.component */ "./src/app/project/project-detail/project-detail.component.ts");
/* harmony import */ var _comment_comment_post_comment_post_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./comment/comment-post/comment-post.component */ "./src/app/comment/comment-post/comment-post.component.ts");
/* harmony import */ var _comment_comment_card_comment_card_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./comment/comment-card/comment-card.component */ "./src/app/comment/comment-card/comment-card.component.ts");
/* harmony import */ var _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./user/user-list/user-list.component */ "./src/app/user/user-list/user-list.component.ts");
/* harmony import */ var _user_user_card_user_card_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./user/user-card/user-card.component */ "./src/app/user/user-card/user-card.component.ts");
/* harmony import */ var _shared_user_service__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./shared/user.service */ "./src/app/shared/user.service.ts");
/* harmony import */ var _project_project_edit_project_edit_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./project/project-edit/project-edit.component */ "./src/app/project/project-edit/project-edit.component.ts");
/* harmony import */ var _comment_comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./comment/comment-list/comment-list.component */ "./src/app/comment/comment-list/comment-list.component.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _shared_pipes_ellipsis_pipe__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./shared/pipes/ellipsis.pipe */ "./src/app/shared/pipes/ellipsis.pipe.ts");
/* harmony import */ var _sidenav_sidenav_component__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./sidenav/sidenav.component */ "./src/app/sidenav/sidenav.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



























var XhrInterceptor = /** @class */ (function () {
    function XhrInterceptor() {
    }
    XhrInterceptor.prototype.intercept = function (req, next) {
        var xhr = req.clone({
            headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
        });
        return next.handle(xhr);
    };
    XhrInterceptor = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], XhrInterceptor);
    return XhrInterceptor;
}());

var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__["NavbarComponent"],
                _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_6__["ProjectListComponent"],
                _project_project_card_project_card_component__WEBPACK_IMPORTED_MODULE_7__["ProjectCardComponent"],
                _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_8__["ProjectPostComponent"],
                _project_project_search_project_search_component__WEBPACK_IMPORTED_MODULE_9__["ProjectSearchComponent"],
                _header_header_component__WEBPACK_IMPORTED_MODULE_10__["HeaderComponent"],
                _about_about_component__WEBPACK_IMPORTED_MODULE_14__["AboutComponent"],
                _footer_footer_component__WEBPACK_IMPORTED_MODULE_15__["FooterComponent"],
                _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_16__["ProjectDetailComponent"],
                _comment_comment_post_comment_post_component__WEBPACK_IMPORTED_MODULE_17__["CommentPostComponent"],
                _comment_comment_card_comment_card_component__WEBPACK_IMPORTED_MODULE_18__["CommentCardComponent"],
                _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_19__["UserListComponent"],
                _user_user_card_user_card_component__WEBPACK_IMPORTED_MODULE_20__["UserCardComponent"],
                _project_project_edit_project_edit_component__WEBPACK_IMPORTED_MODULE_22__["ProjectEditComponent"],
                _comment_comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_23__["CommentListComponent"],
                _shared_pipes_ellipsis_pipe__WEBPACK_IMPORTED_MODULE_25__["EllipsisPipe"],
                _sidenav_sidenav_component__WEBPACK_IMPORTED_MODULE_26__["SidenavComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_12__["ReactiveFormsModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_24__["NgbModule"]
            ],
            providers: [
                _shared_project_service__WEBPACK_IMPORTED_MODULE_13__["ProjectService"], { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"], useClass: XhrInterceptor, multi: true },
                _shared_user_service__WEBPACK_IMPORTED_MODULE_21__["UserService"], { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"], useClass: XhrInterceptor, multi: true },
                _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_6__["ProjectListComponent"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.html":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"comment-card container-fluid\" style=\"margin-bottom: 1.2rem\">\n  <div *ngIf=\"comment != null\">\n    <div *ngIf=\"auth.currentUser?.id == comment?.author?.id\"\n         class=\"author-buttons btn-group-sm\">\n      <button id=\"edit\" class=\"btn btn-outline-secondary\" (click)=\"editComment()\"><i class=\"fa fa-pencil fa-1x\"></i> </button>\n      <button id=\"delete\"\n              class=\"btn btn-danger rounded\"\n              (click)=\"confirmDelete(commentDeleteModal)\"><i class=\"fa fa-trash-o fa-1x\"></i>\n      </button>\n    </div>\n\n\n\n      <!-- Delete comment modal -->\n      <ng-template #commentDeleteModal let-modal>\n        <div class=\"modal-header\">\n          <h5 class=\"modal-title\" id=\"modal-title\">Confirm Deletion</h5>\n        </div>\n        <div class=\"modal-body\" style=\"font-size: 1rem\">\n          <p>Are you sure you want to delete this comment? <br>\n            <br>\n            <em>This <strong>cannot</strong> be undone</em>.</p>\n        </div>\n        <div class=\"modal-footer\">\n          <button type=\"button\" class=\"btn btn-sm btn-danger\" (click)=\"deleteComment()\"><i class=\"fa fa-trash-o\"></i>\n            Delete\n          </button>\n          <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\" (click)=\"modal.close()\">Cancel</button>\n        </div>\n      </ng-template>\n\n    <div class=\"header\">\n      <img class=\"avatar\" src=\"{{comment?.author?.avatar_url}}\">\n      <div class=\"metadata\">\n        <a class=\"clickable login\" href=\"https://github.com/{{comment?.author?.login}}\">\n          <h6>{{comment?.author?.login}}</h6>\n        </a>\n        <div class=\"date\">{{comment?.date_posted | date: 'MMM. d, y'}}</div>\n      </div>\n    </div>\n    <div *ngIf=\"editing\" class=\"form-group\">\n      <div class=\"container mt-4 w-100\">\n      <form (ngSubmit)=\"saveChanges()\" #commentEditForm=\"ngForm\">\n            <textarea type=\"text\" class=\"form-control\"\n                      id=\"comment-body\"\n                      [(ngModel)]=\"comment.body\" name=\"comment-body\" #description=\"ngModel\"\n                      rows=\"5\" >{{comment?.body}}</textarea>\n          <div class=\"form-group edit-buttons btn-group\">\n              <button type=\"submit\"\n                      class=\"btn btn-sm btn-primary\"><i class=\"fa fa-check\"></i>\n                  Save\n              </button>\n              <button id=\"cancel-button\" (click)=\"cancel()\"\n                      class=\"btn btn-sm btn-outline-secondary\"><i class=\"fa fa-close\"></i>\n                  Cancel\n              </button>\n          </div>\n      </form>\n      </div>\n    </div>\n    <p *ngIf=\"!editing\" class=\"comment-body card-body\">{{comment?.body | ellipsis:500}}</p>\n    <hr class=\"my-2\">\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n.comment-card {\n  margin-top: 1rem;\n  padding-top: 1rem;\n  padding-bottom: 1rem;\n  border: 2px solid rgba(51, 51, 51, 0.035); }\n.comment-card .author-buttons {\n    float: right; }\n.comment-card .author-buttons #delete {\n      margin-left: .5rem; }\n.comment-card .header {\n    display: grid;\n    grid-template-columns: -webkit-min-content auto;\n    grid-template-columns: min-content auto; }\n.comment-card .header .avatar {\n      max-height: 50px;\n      max-width: 50px;\n      box-shadow: 0 3px .3rem black;\n      border-radius: 50px; }\n.comment-card .header .metadata {\n      display: grid;\n      grid-template-rows: repeat(2, auto); }\n.comment-card .header .metadata .login {\n        font-family: \"Montserrat\", sans-serif;\n        margin-left: 1rem;\n        font-size: 1rem;\n        margin-bottom: 0; }\n.comment-card .header .metadata .date {\n        font-family: \"Open Sans\", sans-serif;\n        color: gray;\n        font-size: .9rem;\n        margin-left: 1rem;\n        margin-top: 0; }\n.comment-card .comment-body {\n    white-space: pre-wrap;\n    font-family: \"Open Sans\", sans-serif;\n    font-size: .95rem;\n    padding-bottom: 1rem;\n    margin-bottom: 0; }\nform {\n  font-size: 1rem; }\nform .edit-buttons {\n    display: grid;\n    grid-template-columns: repeat(2, -webkit-min-content);\n    grid-template-columns: repeat(2, min-content);\n    justify-content: right;\n    padding-top: 1rem; }\nform .edit-buttons #cancel-button {\n      margin-left: .5rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvY29tbWVudC9jb21tZW50LWNhcmQvY29tbWVudC1jYXJkLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNBLDRFQUFZO0FDQ1o7RUFDRSxpQkFBZ0I7RUFDaEIsa0JBQWlCO0VBQ2pCLHFCQUFvQjtFQUNwQiwwQ0FBeUMsRUFtRDFDO0FBdkREO0lBT0ksYUFBWSxFQUtiO0FBWkg7TUFVTSxtQkFBa0IsRUFDbkI7QUFYTDtJQWVJLGNBQWE7SUFDYixnREFBdUM7SUFBdkMsd0NBQXVDLEVBOEJ4QztBQTlDSDtNQW1CTSxpQkFBZ0I7TUFDaEIsZ0JBQWU7TUFDZiw4QkFBNkI7TUFDN0Isb0JBQW1CLEVBQ3BCO0FBdkJMO01BMEJNLGNBQWE7TUFDYixvQ0FBbUMsRUFrQnBDO0FBN0NMO1FBOEJRLHNDRHRCc0M7UUN1QnRDLGtCQUFpQjtRQUNqQixnQkFBZTtRQUNmLGlCQUFnQixFQUVqQjtBQW5DUDtRQXNDUSxxQ0Q3QnVDO1FDOEJ2QyxZQUFXO1FBQ1gsaUJBQWdCO1FBQ2hCLGtCQUFpQjtRQUNqQixjQUFhLEVBRWQ7QUE1Q1A7SUFpREksc0JBQXFCO0lBQ3JCLHFDRHpDMkM7SUMwQzNDLGtCQUFpQjtJQUNqQixxQkFBb0I7SUFDcEIsaUJBQWdCLEVBQ2pCO0FBR0g7RUFDRSxnQkFBZSxFQVloQjtBQWJEO0lBSUksY0FBYTtJQUNiLHNEQUE2QztJQUE3Qyw4Q0FBNkM7SUFDN0MsdUJBQXNCO0lBQ3RCLGtCQUFpQixFQUtsQjtBQVpIO01BVU0sbUJBQWtCLEVBQ25CIiwiZmlsZSI6InNyYy9hcHAvY29tbWVudC9jb21tZW50LWNhcmQvY29tbWVudC1jYXJkLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLy8kZGFyazogcmdiKDI1LCAyMywgMjIpO1xuQGltcG9ydCB1cmwoJ2h0dHBzOi8vZm9udHMuZ29vZ2xlYXBpcy5jb20vY3NzP2ZhbWlseT1Nb250c2VycmF0fE9wZW4rU2FucycpO1xuXG4kZGFyazogcmdiKDI4LCAzNSwgNDkpO1xuJGJhY2tncm91bmQtbGlnaHQ6IHJnYmEoMjU1LCAyNTEsIDI1NCwgMSk7XG4kYmx1ZTogcmdiKDYyLCA4MCwgOTEpO1xuJHByaW1hcnk6ICRibHVlO1xuJHByaW1hcnktaG92ZXI6IHJnYmEoOTksIDE1OSwgMTcxLCAxKTtcbiRsaWdodC1ncmF5LWxpbmUtYm9yZGVyOiAjZTZlNmU2IDJweCBzb2xpZDtcbiRiZy1ncmF5OiAjZTZlNmU2O1xuJGZvbnQtZmFtaWx5LXByaW1hcnk6ICdNb250c2VycmF0Jywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1zZWNvbmRhcnk6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtc2l6ZS1iYXNlOiAxcmVtO1xuJGZvbnQtZmFtaWx5LWJhc2U6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LWNvZGU6ICdTb3VyY2UgQ29kZSBQcm8nLCBtb25vc3BhY2U7XG5cbiRjb2xvcnM6IChcbiAgcHJpbWFyeTogJHByaW1hcnksXG4gIGhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgZGFyazogJGRhcmssXG4gIGJnLWxpZ2h0OiAkYmFja2dyb3VuZC1saWdodCxcbiAgcHJpbWFyeS1ob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGJnLWdyYXk6ICRiZy1ncmF5XG4pO1xuXG5AZnVuY3Rpb24gY29sb3IoJGNvbG9yKSB7XG4gIEByZXR1cm4gbWFwLWdldCgkY29sb3JzLCAkY29sb3IpXG59XG5cbiR0aGVtZS1jb2xvcnM6IChcbiAgXCJwcmltYXJ5XCI6ICRwcmltYXJ5LFxuICBcInByaW1hcnktaG92ZXJcIjogJHByaW1hcnktaG92ZXJcbik7XG5cblxuLmNvbnRhaW5lci1mbHVpZCB7XG5cbn1cbiIsIkBpbXBvcnQgXCJ+c3JjL192YXJpYWJsZXMuc2Nzc1wiO1xuXG4uY29tbWVudC1jYXJkIHtcbiAgbWFyZ2luLXRvcDogMXJlbTtcbiAgcGFkZGluZy10b3A6IDFyZW07XG4gIHBhZGRpbmctYm90dG9tOiAxcmVtO1xuICBib3JkZXI6IDJweCBzb2xpZCByZ2JhKDUxLCA1MSwgNTEsIDAuMDM1KTtcblxuICAuYXV0aG9yLWJ1dHRvbnMge1xuICAgIGZsb2F0OiByaWdodDtcblxuICAgICNkZWxldGUge1xuICAgICAgbWFyZ2luLWxlZnQ6IC41cmVtO1xuICAgIH1cbiAgfVxuXG4gIC5oZWFkZXIge1xuICAgIGRpc3BsYXk6IGdyaWQ7XG4gICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiBtaW4tY29udGVudCBhdXRvO1xuXG4gICAgLmF2YXRhciB7XG4gICAgICBtYXgtaGVpZ2h0OiA1MHB4O1xuICAgICAgbWF4LXdpZHRoOiA1MHB4O1xuICAgICAgYm94LXNoYWRvdzogMCAzcHggLjNyZW0gYmxhY2s7XG4gICAgICBib3JkZXItcmFkaXVzOiA1MHB4O1xuICAgIH1cblxuICAgIC5tZXRhZGF0YSB7XG4gICAgICBkaXNwbGF5OiBncmlkO1xuICAgICAgZ3JpZC10ZW1wbGF0ZS1yb3dzOiByZXBlYXQoMiwgYXV0byk7XG5cbiAgICAgIC5sb2dpbiB7XG4gICAgICAgIGZvbnQtZmFtaWx5OiAkZm9udC1mYW1pbHktcHJpbWFyeTtcbiAgICAgICAgbWFyZ2luLWxlZnQ6IDFyZW07XG4gICAgICAgIGZvbnQtc2l6ZTogMXJlbTtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogMDtcblxuICAgICAgfVxuXG4gICAgICAuZGF0ZSB7XG4gICAgICAgIGZvbnQtZmFtaWx5OiAkZm9udC1mYW1pbHktc2Vjb25kYXJ5O1xuICAgICAgICBjb2xvcjogZ3JheTtcbiAgICAgICAgZm9udC1zaXplOiAuOXJlbTtcbiAgICAgICAgbWFyZ2luLWxlZnQ6IDFyZW07XG4gICAgICAgIG1hcmdpbi10b3A6IDA7XG5cbiAgICAgIH1cbiAgICB9XG4gIH1cbiAgLmNvbW1lbnQtYm9keSB7XG4gICAgLy9tYXJnaW4tdG9wOiAxcmVtO1xuICAgIHdoaXRlLXNwYWNlOiBwcmUtd3JhcDtcbiAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXNlY29uZGFyeTtcbiAgICBmb250LXNpemU6IC45NXJlbTtcbiAgICBwYWRkaW5nLWJvdHRvbTogMXJlbTtcbiAgICBtYXJnaW4tYm90dG9tOiAwO1xuICB9XG59XG5cbmZvcm0ge1xuICBmb250LXNpemU6IDFyZW07XG5cbiAgLmVkaXQtYnV0dG9ucyB7XG4gICAgZGlzcGxheTogZ3JpZDtcbiAgICBncmlkLXRlbXBsYXRlLWNvbHVtbnM6IHJlcGVhdCgyLCBtaW4tY29udGVudCk7XG4gICAganVzdGlmeS1jb250ZW50OiByaWdodDtcbiAgICBwYWRkaW5nLXRvcDogMXJlbTtcblxuICAgICNjYW5jZWwtYnV0dG9uIHtcbiAgICAgIG1hcmdpbi1sZWZ0OiAuNXJlbTtcbiAgICB9XG4gIH1cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.ts ***!
  \****************************************************************/
/*! exports provided: CommentCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentCardComponent", function() { return CommentCardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../comment-list/comment-list.component */ "./src/app/comment/comment-list/comment-list.component.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var CommentCardComponent = /** @class */ (function () {
    function CommentCardComponent(auth, projectService, route, commentList, modalService) {
        var _this = this;
        this.auth = auth;
        this.projectService = projectService;
        this.route = route;
        this.commentList = commentList;
        this.modalService = modalService;
        this.editing = false;
        this.route.params.subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    }
    CommentCardComponent.prototype.ngOnInit = function () {
    };
    CommentCardComponent.prototype.confirmDelete = function (content) {
        this.modalService.open(content, { centered: true });
    };
    CommentCardComponent.prototype.editComment = function () {
        this.editing = !this.editing;
    };
    CommentCardComponent.prototype.saveChanges = function () {
        var _this = this;
        this.projectService.editComment(this.comment, this.projectId)
            .subscribe(function (status) { return console.log(status); }, function (err) { return console.error(err.message); }, function () { return _this.editing = false; });
    };
    CommentCardComponent.prototype.deleteComment = function () {
        var _this = this;
        this.projectService.deleteComment(this.projectId, this.comment.id)
            .subscribe(function () { }, function (err) { return console.error(err.message); }, function () { return _this.commentList.refreshCommentList(); })
            .add(this.modalService.dismissAll());
    };
    CommentCardComponent.prototype.cancel = function () {
        this.editing = false;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], CommentCardComponent.prototype, "comment", void 0);
    CommentCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-card',
            template: __webpack_require__(/*! ./comment-card.component.html */ "./src/app/comment/comment-card/comment-card.component.html"),
            styles: [__webpack_require__(/*! ./comment-card.component.scss */ "./src/app/comment/comment-card/comment-card.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"],
            _shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            _comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_4__["CommentListComponent"],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__["NgbModal"]])
    ], CommentCardComponent);
    return CommentCardComponent;
}());



/***/ }),

/***/ "./src/app/comment/comment-list/comment-list.component.html":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-list/comment-list.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"comments\" class=\"container\">\n  <div class=\"comment-post-form\">\n    <hr class=\"my-2\">\n    <app-comment-post></app-comment-post>\n  </div>\n  <div class=\"comment-list-metadata\">\n    <div class=\"result-number\">{{comments?.total_elements}} comment(s)</div>\n    <select class=\"sort-order\" title=\"order\">\n      <option value=\"new\" (click)=\"sortByNewest()\">newest</option>\n      <option value=\"old\" (click)=\"sortByOldest()\">oldest</option>\n    </select>\n    <ul class=\"pagination-sm\">\n      <li [class]=\"comments?.first ? 'page-item disabled' : 'page-item'\">\n        <a class=\"page-link\" (click)=\"prevCommentPage()\">prev</a>\n      </li>\n      <li [class]=\"comments?.last ? 'page-item disabled' : 'page-item'\">\n        <a class=\"page-link\" (click)=\"nextCommentPage()\">next</a>\n      </li>\n    </ul>\n  </div>\n  <ul class=\"comment-list\" [@listStagger]=\"comments\" style=\"min-height: fit-content; padding: 0\">\n    <li *ngFor=\"let comment of comments?.content\" style=\"min-height: fit-content\">\n      <app-comment-card [comment]=\"comment\"></app-comment-card>\n    </li>\n  </ul>\n  <p class=\"align-self-center\" *ngIf=\"comments?.number_of_elements === 0\">Be the first to comment.</p>\n  <ul *ngIf=\"comments?.number_of_elements > 0\" class=\"pagination-sm d-flex float-right\" style=\"margin-right: 3rem; padding-bottom: 20px\">\n    <li [class]=\"comments?.first ? 'page-item disabled' : 'page-item'\">\n      <a class=\"page-link\" (click)=\"prevCommentPage()\">prev</a>\n    </li>\n    <li [class]=\"comments?.last ? 'page-item disabled' : 'page-item'\">\n      <a class=\"page-link\" (click)=\"nextCommentPage()\">next</a>\n    </li>\n  </ul>\n</div>\n"

/***/ }),

/***/ "./src/app/comment/comment-list/comment-list.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-list/comment-list.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n#comments {\n  font-family: \"Open Sans\", sans-serif;\n  font-size: 1rem;\n  padding-bottom: 5rem; }\n#comments .comment-list-metadata {\n    display: grid;\n    grid-template-columns: repeat(3, auto);\n    justify-items: center; }\n#comments .comment-list-metadata .sort-order {\n      margin: 0;\n      width: 6rem;\n      height: 1.3rem;\n      padding: 0; }\n#comments .comment-list-metadata .pagination-sm {\n      display: flex; }\n#comments .comment-post-form {\n    padding-top: 2rem; }\n#comments .comment-list {\n    list-style-type: none;\n    padding: 0; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvY29tbWVudC9jb21tZW50LWxpc3QvY29tbWVudC1saXN0LmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNBLDRFQUFZO0FDQ1o7RUFDRSxxQ0RRNkM7RUNQN0MsZ0JBQWU7RUFDZixxQkFBb0IsRUFpQ3JCO0FBcENEO0lBTUksY0FBYTtJQUNiLHVDQUFzQztJQUN0QyxzQkFBcUIsRUFldEI7QUF2Qkg7TUFjTSxVQUFTO01BQ1QsWUFBVztNQUNYLGVBQWM7TUFDZCxXQUFVLEVBQ1g7QUFsQkw7TUFxQk0sY0FBYSxFQUNkO0FBdEJMO0lBMEJJLGtCQUFpQixFQUNsQjtBQTNCSDtJQThCSSxzQkFBcUI7SUFDckIsV0FBVSxFQUVYIiwiZmlsZSI6InNyYy9hcHAvY29tbWVudC9jb21tZW50LWxpc3QvY29tbWVudC1saXN0LmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLy8kZGFyazogcmdiKDI1LCAyMywgMjIpO1xuQGltcG9ydCB1cmwoJ2h0dHBzOi8vZm9udHMuZ29vZ2xlYXBpcy5jb20vY3NzP2ZhbWlseT1Nb250c2VycmF0fE9wZW4rU2FucycpO1xuXG4kZGFyazogcmdiKDI4LCAzNSwgNDkpO1xuJGJhY2tncm91bmQtbGlnaHQ6IHJnYmEoMjU1LCAyNTEsIDI1NCwgMSk7XG4kYmx1ZTogcmdiKDYyLCA4MCwgOTEpO1xuJHByaW1hcnk6ICRibHVlO1xuJHByaW1hcnktaG92ZXI6IHJnYmEoOTksIDE1OSwgMTcxLCAxKTtcbiRsaWdodC1ncmF5LWxpbmUtYm9yZGVyOiAjZTZlNmU2IDJweCBzb2xpZDtcbiRiZy1ncmF5OiAjZTZlNmU2O1xuJGZvbnQtZmFtaWx5LXByaW1hcnk6ICdNb250c2VycmF0Jywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1zZWNvbmRhcnk6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtc2l6ZS1iYXNlOiAxcmVtO1xuJGZvbnQtZmFtaWx5LWJhc2U6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LWNvZGU6ICdTb3VyY2UgQ29kZSBQcm8nLCBtb25vc3BhY2U7XG5cbiRjb2xvcnM6IChcbiAgcHJpbWFyeTogJHByaW1hcnksXG4gIGhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgZGFyazogJGRhcmssXG4gIGJnLWxpZ2h0OiAkYmFja2dyb3VuZC1saWdodCxcbiAgcHJpbWFyeS1ob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGJnLWdyYXk6ICRiZy1ncmF5XG4pO1xuXG5AZnVuY3Rpb24gY29sb3IoJGNvbG9yKSB7XG4gIEByZXR1cm4gbWFwLWdldCgkY29sb3JzLCAkY29sb3IpXG59XG5cbiR0aGVtZS1jb2xvcnM6IChcbiAgXCJwcmltYXJ5XCI6ICRwcmltYXJ5LFxuICBcInByaW1hcnktaG92ZXJcIjogJHByaW1hcnktaG92ZXJcbik7XG5cblxuLmNvbnRhaW5lci1mbHVpZCB7XG5cbn1cbiIsIkBpbXBvcnQgXCJ+c3JjL192YXJpYWJsZXMuc2Nzc1wiO1xuXG4jY29tbWVudHMge1xuICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXNlY29uZGFyeTtcbiAgZm9udC1zaXplOiAxcmVtO1xuICBwYWRkaW5nLWJvdHRvbTogNXJlbTtcblxuICAuY29tbWVudC1saXN0LW1ldGFkYXRhIHtcbiAgICBkaXNwbGF5OiBncmlkO1xuICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogcmVwZWF0KDMsIGF1dG8pO1xuICAgIGp1c3RpZnktaXRlbXM6IGNlbnRlcjtcblxuICAgIC5yZXN1bHQtYW1vdW50IHtcbiAgICB9XG5cbiAgICAuc29ydC1vcmRlciB7XG4gICAgICBtYXJnaW46IDA7XG4gICAgICB3aWR0aDogNnJlbTtcbiAgICAgIGhlaWdodDogMS4zcmVtO1xuICAgICAgcGFkZGluZzogMDtcbiAgICB9XG5cbiAgICAucGFnaW5hdGlvbi1zbSB7XG4gICAgICBkaXNwbGF5OiBmbGV4O1xuICAgIH1cbiAgfVxuXG4gIC5jb21tZW50LXBvc3QtZm9ybSB7XG4gICAgcGFkZGluZy10b3A6IDJyZW07XG4gIH1cblxuICAuY29tbWVudC1saXN0IHtcbiAgICBsaXN0LXN0eWxlLXR5cGU6IG5vbmU7XG4gICAgcGFkZGluZzogMDtcblxuICB9XG5cblxufVxuIl19 */"

/***/ }),

/***/ "./src/app/comment/comment-list/comment-list.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/comment/comment-list/comment-list.component.ts ***!
  \****************************************************************/
/*! exports provided: CommentListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentListComponent", function() { return CommentListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var CommentListComponent = /** @class */ (function () {
    function CommentListComponent(projectService, route) {
        var _this = this;
        this.projectService = projectService;
        this.route = route;
        this.destroy = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
        this.route.params.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["takeUntil"])(this.destroy))
            .subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    }
    CommentListComponent.prototype.ngOnInit = function () {
        this.pageNum = 0;
        this.sortByNewest();
    };
    CommentListComponent.prototype.sortByOldest = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_1__["SortOrder"].ASC;
        this.fetchComments();
    };
    CommentListComponent.prototype.sortByNewest = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_1__["SortOrder"].DESC;
        this.fetchComments();
    };
    CommentListComponent.prototype.nextCommentPage = function () {
        if (!this.comments.last) {
            this.pageNum++;
            this.fetchComments();
        }
    };
    CommentListComponent.prototype.prevCommentPage = function () {
        if (!this.comments.first) {
            this.pageNum--;
            this.fetchComments();
        }
    };
    CommentListComponent.prototype.fetchComments = function () {
        var _this = this;
        this.projectService.fetchProjectComments(this.projectId, this.order, this.pageNum)
            .subscribe(function (data) { return _this.comments = data; }, function (err) { return console.error(err.message); });
    };
    CommentListComponent.prototype.refreshCommentList = function () {
        this.sortByNewest();
    };
    CommentListComponent.prototype.ngOnDestroy = function () {
        this.destroy.next();
        this.destroy.complete();
    };
    CommentListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-list',
            template: __webpack_require__(/*! ./comment-list.component.html */ "./src/app/comment/comment-list/comment-list.component.html"),
            styles: [__webpack_require__(/*! ./comment-list.component.scss */ "./src/app/comment/comment-list/comment-list.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["trigger"])('listStagger', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["transition"])('* <=> *', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["query"])(':enter', [
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["style"])({ opacity: 0, transform: 'translateY(-15px)' }),
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["stagger"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["animate"])('550ms ease-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_4__["style"])({ opacity: 1, transform: 'translateY(0px)' })))
                        ], { optional: true }),
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]])
    ], CommentListComponent);
    return CommentListComponent;
}());



/***/ }),

/***/ "./src/app/comment/comment-post/comment-creation.ts":
/*!**********************************************************!*\
  !*** ./src/app/comment/comment-post/comment-creation.ts ***!
  \**********************************************************/
/*! exports provided: CommentCreation */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentCreation", function() { return CommentCreation; });
var CommentCreation = /** @class */ (function () {
    function CommentCreation(body) {
        this.body = body;
    }
    return CommentCreation;
}());



/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.html":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"form-group\" [formGroup]=\"commentPostForm\">\n\n  <label for=\"comment-body\">\n    <span *ngIf=\"auth.authenticated && commentPostForm.dirty\">Share a comment</span>\n    <span *ngIf=\"!auth.authenticated\">\n    <a class=\"clickable\" href=\"http://localhost:8080/oauth2/authorization/github\">Log in to post a comment</a></span>\n  </label>\n  <textarea type=\"text\"\n            class=\"form-control\"\n            formControlName=\"body\"\n            id=\"comment-body\"\n            rows=\"3\" [placeholder]=\"'Share a comment.'\">\n  </textarea>\n\n  <div class=\"container-fluid\" style=\"padding-top: .5rem\">\n    <ngb-alert *ngIf=\"submitted\" type=\"success\" (close)=\"submitted = false\">Comment submitted.</ngb-alert>\n    <div [@formValid]=\"commentPostForm.valid ? 'valid' : 'invalid'\" *ngIf=\"!submitted\" class=\"buttons\">\n\n      <button *ngIf=\"commentPostForm.dirty\" (click)=\"submit()\" [disabled]=\"!commentPostForm.valid\"\n              class=\"btn btn-primary btn-sm clickable\"> Submit\n      </button>\n      <button *ngIf=\"commentPostForm.valid\" id='clear' (click)=\"clearText()\"\n              class=\"btn btn-sm btn-outline-secondary\"><i class=\"fa fa-close\"> </i> Cancel\n      </button>\n    </div>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".buttons {\n  margin-top: .2rem; }\n  .buttons #clear {\n    margin-left: .5rem; }\n  .ng-invalid.buttons.btn-primary {\n  opacity: 1; }\n  .alert-success {\n  font-family: Montserrat, sans-serif;\n  font-size: .8rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL2NvbW1lbnQvY29tbWVudC1wb3N0L2NvbW1lbnQtcG9zdC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGtCQUFpQixFQUtsQjtFQU5EO0lBSUksbUJBQWtCLEVBQ25CO0VBR0g7RUFDRSxXQUFVLEVBQ1g7RUFFRDtFQUNFLG9DQUFtQztFQUNuQyxpQkFBZ0IsRUFDakIiLCJmaWxlIjoic3JjL2FwcC9jb21tZW50L2NvbW1lbnQtcG9zdC9jb21tZW50LXBvc3QuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuYnV0dG9ucyB7XG4gIG1hcmdpbi10b3A6IC4ycmVtO1xuXG4gICNjbGVhciB7XG4gICAgbWFyZ2luLWxlZnQ6IC41cmVtO1xuICB9XG59XG5cbi5uZy1pbnZhbGlkLmJ1dHRvbnMuYnRuLXByaW1hcnkge1xuICBvcGFjaXR5OiAxO1xufVxuXG4uYWxlcnQtc3VjY2VzcyB7XG4gIGZvbnQtZmFtaWx5OiBNb250c2VycmF0LCBzYW5zLXNlcmlmO1xuICBmb250LXNpemU6IC44cmVtO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.ts ***!
  \****************************************************************/
/*! exports provided: CommentPostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentPostComponent", function() { return CommentPostComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _comment_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./comment-creation */ "./src/app/comment/comment-post/comment-creation.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../comment-list/comment-list.component */ "./src/app/comment/comment-list/comment-list.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};










var CommentPostComponent = /** @class */ (function () {
    function CommentPostComponent(auth, projectService, route, commentList, fb) {
        this.auth = auth;
        this.projectService = projectService;
        this.route = route;
        this.commentList = commentList;
        this.fb = fb;
        this.commentPostForm = this.fb.group({
            body: [{ value: '', disabled: !this.auth.authenticated },
                [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_6__["Validators"].required,
                    this.textLengthTrimValidator(3)
                ]
            ]
        });
        this.destroy = new rxjs__WEBPACK_IMPORTED_MODULE_9__["Subject"]();
    }
    CommentPostComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_8__["takeUntil"])(this.destroy))
            .subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.error(err.message); });
    };
    CommentPostComponent.prototype.submit = function () {
        var _this = this;
        var formValue = this.commentPostForm.controls['body'].value;
        var newComment = new _comment_creation__WEBPACK_IMPORTED_MODULE_1__["CommentCreation"](formValue.trim());
        this.projectService.postComment(this.projectId, newComment)
            .subscribe(function (data) { return console.log(data.status); }, function (err) { return console.log(err.message); }, function () { return _this.commentList.refreshCommentList(); })
            .add(function () {
            _this.clearText();
            _this.submitted = true;
        });
        /* To make the 'comment submitted' alert disappear after 5 seconds. */
        setTimeout(function () { return _this.submitted = false; }, 5000);
    };
    CommentPostComponent.prototype.textLengthTrimValidator = function (requiredLength) {
        return function (control) {
            var text = control.value.toString();
            var invalid = (text === undefined || text.trim().length < requiredLength);
            return invalid ? { 'Not required length': text } : undefined;
        };
    };
    CommentPostComponent.prototype.ngOnDestroy = function () {
        this.destroy.next();
        this.destroy.complete();
    };
    CommentPostComponent.prototype.clearText = function () {
        this.commentPostForm.patchValue({ body: '' });
        this.commentPostForm.markAsPristine();
    };
    CommentPostComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-post',
            template: __webpack_require__(/*! ./comment-post.component.html */ "./src/app/comment/comment-post/comment-post.component.html"),
            styles: [__webpack_require__(/*! ./comment-post.component.scss */ "./src/app/comment/comment-post/comment-post.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["trigger"])('formValid', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["state"])('invalid', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["style"])({
                        opacity: '.5'
                    })),
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["state"])('valid', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["style"])({
                        opacity: '1'
                    })),
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["transition"])('invalid => valid', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["animate"])('.5s ease-in')
                    ]),
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["transition"])('valid => invalid', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_7__["animate"])('.5s ease-out')
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"],
            _shared_project_service__WEBPACK_IMPORTED_MODULE_3__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"],
            _comment_list_comment_list_component__WEBPACK_IMPORTED_MODULE_5__["CommentListComponent"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormBuilder"]])
    ], CommentPostComponent);
    return CommentPostComponent;
}());



/***/ }),

/***/ "./src/app/footer/footer.component.html":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<footer class=\"jumbotron jumbotron-fluid\" style=\"margin-bottom: 0; z-index: revert\">\n  <div class=\"max-width-wrapper container\">\n    <div id=\"footer-content\" class=\"container\" style=\"min-height: 5rem\">\n      <div id=\"footer-links\">\n        <p>Created with <i class=\"fa fa-heart\"></i> using Spring Boot + Angular</p>\n        <div class=\"logos\">\n        <img id=\"spring-logo\" src=\"./spring-logo.png\">\n        <i class=\"fa fa-plus\"></i>\n        <img id=\"angular-logo\" src=\"./angular-logo.png\">\n        </div>\n      </div>\n    </div>\n  </div>\n</footer>\n\n"

/***/ }),

/***/ "./src/app/footer/footer.component.scss":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\nfooter {\n  background-color: #1c2331;\n  overflow-x: unset; }\nfooter .max-width-wrapper {\n    color: #fffbfe; }\nfooter .max-width-wrapper #footer-content {\n      font-size: 1rem;\n      text-align: center;\n      padding-top: 1rem;\n      font-family: \"Open Sans\", sans-serif; }\nfooter .max-width-wrapper .logos {\n      padding-top: 0;\n      margin-top: 0; }\nfooter .max-width-wrapper .logos #spring-logo {\n        max-height: 20px;\n        padding-right: 10px; }\nfooter .max-width-wrapper .logos #angular-logo {\n        padding-left: 10px;\n        border-radius: 50px;\n        max-height: 30px; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvZm9vdGVyL2Zvb3Rlci5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSw0RUFBWTtBQ0NaO0VBQ0UsMEJEQW9CO0VDQ3BCLGtCQUFpQixFQXFDbEI7QUF2Q0Q7SUFTSSxlRFBxQyxFQ29DdEM7QUF0Q0g7TUFlTSxnQkFBZTtNQUNmLG1CQUFrQjtNQUNsQixrQkFBaUI7TUFDakIscUNEVHlDLEVDVTFDO0FBbkJMO01Bc0JNLGVBQWM7TUFDZCxjQUFhLEVBY2Q7QUFyQ0w7UUEwQlEsaUJBQWdCO1FBQ2hCLG9CQUFtQixFQUNwQjtBQTVCUDtRQStCUSxtQkFBa0I7UUFHbEIsb0JBQW1CO1FBQ25CLGlCQUFnQixFQUNqQiIsImZpbGUiOiJzcmMvYXBwL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvLyRkYXJrOiByZ2IoMjUsIDIzLCAyMik7XG5AaW1wb3J0IHVybCgnaHR0cHM6Ly9mb250cy5nb29nbGVhcGlzLmNvbS9jc3M/ZmFtaWx5PU1vbnRzZXJyYXR8T3BlbitTYW5zJyk7XG5cbiRkYXJrOiByZ2IoMjgsIDM1LCA0OSk7XG4kYmFja2dyb3VuZC1saWdodDogcmdiYSgyNTUsIDI1MSwgMjU0LCAxKTtcbiRibHVlOiByZ2IoNjIsIDgwLCA5MSk7XG4kcHJpbWFyeTogJGJsdWU7XG4kcHJpbWFyeS1ob3ZlcjogcmdiYSg5OSwgMTU5LCAxNzEsIDEpO1xuJGxpZ2h0LWdyYXktbGluZS1ib3JkZXI6ICNlNmU2ZTYgMnB4IHNvbGlkO1xuJGJnLWdyYXk6ICNlNmU2ZTY7XG4kZm9udC1mYW1pbHktcHJpbWFyeTogJ01vbnRzZXJyYXQnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LXNlY29uZGFyeTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1zaXplLWJhc2U6IDFyZW07XG4kZm9udC1mYW1pbHktYmFzZTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktY29kZTogJ1NvdXJjZSBDb2RlIFBybycsIG1vbm9zcGFjZTtcblxuJGNvbG9yczogKFxuICBwcmltYXJ5OiAkcHJpbWFyeSxcbiAgaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBkYXJrOiAkZGFyayxcbiAgYmctbGlnaHQ6ICRiYWNrZ3JvdW5kLWxpZ2h0LFxuICBwcmltYXJ5LWhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgYmctZ3JheTogJGJnLWdyYXlcbik7XG5cbkBmdW5jdGlvbiBjb2xvcigkY29sb3IpIHtcbiAgQHJldHVybiBtYXAtZ2V0KCRjb2xvcnMsICRjb2xvcilcbn1cblxuJHRoZW1lLWNvbG9yczogKFxuICBcInByaW1hcnlcIjogJHByaW1hcnksXG4gIFwicHJpbWFyeS1ob3ZlclwiOiAkcHJpbWFyeS1ob3ZlclxuKTtcblxuXG4uY29udGFpbmVyLWZsdWlkIHtcblxufVxuIiwiQGltcG9ydCBcIn5zcmMvX3ZhcmlhYmxlc1wiO1xuXG5mb290ZXIge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiBjb2xvcihkYXJrKTtcbiAgb3ZlcmZsb3cteDogdW5zZXQ7XG5cbiAgLmp1bWJvdHJvbiB7XG5cbiAgfVxuXG4gIC5tYXgtd2lkdGgtd3JhcHBlciB7XG4gICAgY29sb3I6ICRiYWNrZ3JvdW5kLWxpZ2h0O1xuXG4gICAgI2Zvb3Rlci1jb250ZW50IHtcbiAgICAgIC8vZGlzcGxheTogZ3JpZDtcbiAgICAgIC8vZ3JpZC10ZW1wbGF0ZS1yb3dzOiByZXBlYXQoMiwgMTBweCk7XG4gICAgICAvL2dyaWQtdGVtcGxhdGUtY29sdW1uczogcmVwZWF0KDIsIGF1dG8pO1xuICAgICAgZm9udC1zaXplOiAxcmVtO1xuICAgICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgICAgcGFkZGluZy10b3A6IDFyZW07XG4gICAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXNlY29uZGFyeTtcbiAgICB9XG5cbiAgICAubG9nb3Mge1xuICAgICAgcGFkZGluZy10b3A6IDA7XG4gICAgICBtYXJnaW4tdG9wOiAwO1xuXG4gICAgICAjc3ByaW5nLWxvZ28ge1xuICAgICAgICBtYXgtaGVpZ2h0OiAyMHB4O1xuICAgICAgICBwYWRkaW5nLXJpZ2h0OiAxMHB4O1xuICAgICAgfVxuXG4gICAgICAjYW5ndWxhci1sb2dvIHtcbiAgICAgICAgcGFkZGluZy1sZWZ0OiAxMHB4O1xuICAgICAgICAtd2Via2l0LWJvcmRlci1yYWRpdXM6IDUwcHg7XG4gICAgICAgIC1tb3otYm9yZGVyLXJhZGl1czogNTBweDtcbiAgICAgICAgYm9yZGVyLXJhZGl1czogNTBweDtcbiAgICAgICAgbWF4LWhlaWdodDogMzBweDtcbiAgICAgIH1cbiAgICB9XG4gIH1cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/footer/footer.component.ts":
/*!********************************************!*\
  !*** ./src/app/footer/footer.component.ts ***!
  \********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var FooterComponent = /** @class */ (function () {
    function FooterComponent() {
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.scss */ "./src/app/footer/footer.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/header/header.component.html":
/*!**********************************************!*\
  !*** ./src/app/header/header.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"header\">\n  <div class=\"jumbotron pt-5 pb-0\">\n    <h1 class=\"text-center display-4\">{{headerText}}</h1>\n    <hr>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/header/header.component.scss":
/*!**********************************************!*\
  !*** ./src/app/header/header.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n#header .jumbotron {\n  background-color: transparent; }\n#header .jumbotron h1 {\n    margin-left: 1rem;\n    margin-right: 1rem;\n    line-break: normal;\n    font-family: 'Helvetica Neue', sans-serif; }\n#header button {\n  justify-self: end; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvaGVhZGVyL2hlYWRlci5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSw0RUFBWTtBQ0NaO0VBR0ksOEJBQTZCLEVBUTlCO0FBWEg7SUFNTSxrQkFBaUI7SUFDakIsbUJBQWtCO0lBQ2xCLG1CQUFtQjtJQUNuQiwwQ0FBeUMsRUFDMUM7QUFWTDtFQWlCSSxrQkFBaUIsRUFFbEIiLCJmaWxlIjoic3JjL2FwcC9oZWFkZXIvaGVhZGVyLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLy8kZGFyazogcmdiKDI1LCAyMywgMjIpO1xuQGltcG9ydCB1cmwoJ2h0dHBzOi8vZm9udHMuZ29vZ2xlYXBpcy5jb20vY3NzP2ZhbWlseT1Nb250c2VycmF0fE9wZW4rU2FucycpO1xuXG4kZGFyazogcmdiKDI4LCAzNSwgNDkpO1xuJGJhY2tncm91bmQtbGlnaHQ6IHJnYmEoMjU1LCAyNTEsIDI1NCwgMSk7XG4kYmx1ZTogcmdiKDYyLCA4MCwgOTEpO1xuJHByaW1hcnk6ICRibHVlO1xuJHByaW1hcnktaG92ZXI6IHJnYmEoOTksIDE1OSwgMTcxLCAxKTtcbiRsaWdodC1ncmF5LWxpbmUtYm9yZGVyOiAjZTZlNmU2IDJweCBzb2xpZDtcbiRiZy1ncmF5OiAjZTZlNmU2O1xuJGZvbnQtZmFtaWx5LXByaW1hcnk6ICdNb250c2VycmF0Jywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1zZWNvbmRhcnk6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtc2l6ZS1iYXNlOiAxcmVtO1xuJGZvbnQtZmFtaWx5LWJhc2U6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LWNvZGU6ICdTb3VyY2UgQ29kZSBQcm8nLCBtb25vc3BhY2U7XG5cbiRjb2xvcnM6IChcbiAgcHJpbWFyeTogJHByaW1hcnksXG4gIGhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgZGFyazogJGRhcmssXG4gIGJnLWxpZ2h0OiAkYmFja2dyb3VuZC1saWdodCxcbiAgcHJpbWFyeS1ob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGJnLWdyYXk6ICRiZy1ncmF5XG4pO1xuXG5AZnVuY3Rpb24gY29sb3IoJGNvbG9yKSB7XG4gIEByZXR1cm4gbWFwLWdldCgkY29sb3JzLCAkY29sb3IpXG59XG5cbiR0aGVtZS1jb2xvcnM6IChcbiAgXCJwcmltYXJ5XCI6ICRwcmltYXJ5LFxuICBcInByaW1hcnktaG92ZXJcIjogJHByaW1hcnktaG92ZXJcbik7XG5cblxuLmNvbnRhaW5lci1mbHVpZCB7XG5cbn1cbiIsIkBpbXBvcnQgXCJ+c3JjL192YXJpYWJsZXMuc2Nzc1wiO1xuXG4jaGVhZGVyIHtcblxuICAuanVtYm90cm9uIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcblxuICAgIGgxIHtcbiAgICAgIG1hcmdpbi1sZWZ0OiAxcmVtO1xuICAgICAgbWFyZ2luLXJpZ2h0OiAxcmVtO1xuICAgICAgbGluZS1icmVhazogbm9ybWFsIDtcbiAgICAgIGZvbnQtZmFtaWx5OiAnSGVsdmV0aWNhIE5ldWUnLCBzYW5zLXNlcmlmO1xuICAgIH1cbiAgfVxuXG5cblxuXG4gIGJ1dHRvbiB7XG4gICAganVzdGlmeS1zZWxmOiBlbmQ7XG5cbiAgfVxufVxuIl19 */"

/***/ }),

/***/ "./src/app/header/header.component.ts":
/*!********************************************!*\
  !*** ./src/app/header/header.component.ts ***!
  \********************************************/
/*! exports provided: HeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderComponent", function() { return HeaderComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HeaderComponent = /** @class */ (function () {
    function HeaderComponent() {
    }
    HeaderComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", String)
    ], HeaderComponent.prototype, "headerText", void 0);
    HeaderComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-header',
            template: __webpack_require__(/*! ./header.component.html */ "./src/app/header/header.component.html"),
            styles: [__webpack_require__(/*! ./header.component.scss */ "./src/app/header/header.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "./src/app/navbar/navbar.component.html":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<nav class=\"navbar navbar-expand-sm navbar-dark\">\n  <div id=\"inner-nav\" class=\"container max-width-wrapper\">\n    <a class=\"navbar-brand\" routerLink=\"/\">(sudoCode);</a>\n    <button (click)=\"collapsed = !collapsed\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#mainNav\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div [ngbCollapse]=\"collapsed\" class=\"collapse navbar-collapse\" id=\"mainNav\">\n      <div class=\"navbar-expand\">\n        <ul class=\"navbar-nav\">\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             [routerLinkActiveOptions]=\"{exact: true}\" routerLink=\"/\">Home</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"projects\">Projects</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n          routerLink=\"users\">Users</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n              routerLink=\"about\">About</a>\n        </ul>\n      </div>\n    </div>\n    <div ngbDropdown placement=\"bottom-center\" class=\"d-inline-block flex-sm-column\">\n      <div id=\"user-info\">\n        <a *ngIf=\"auth.authenticated\" ngbDropdownToggle>\n          <span id=\"login\">{{auth.currentUser.login}}</span>\n          <img src=\"{{auth.currentUser.avatar_url}}\">\n        </a>\n      </div>\n      <button *ngIf=\"!auth?.authenticated\"  class=\"btn btn-sm rounded\" (click)=\"login()\">\n          <i class=\"fa fa-github fa-1x\"></i> Login with Github</button>\n      <div *ngIf=\"auth.authenticated\" ngbDropdownMenu id=\"user-options\" aria-labelledby=\"user-options\">\n        <button class=\"dropdown-item\" (click)=\"logout()\">Logout</button>\n        <button class=\"dropdown-item\">Settings</button>\n      </div>\n    </div>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/navbar/navbar.component.scss":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n.navbar {\n  background-color: #1c2331 !important;\n  font-size: .9rem;\n  font-family: 'Montserrat', sans-serif;\n  min-height: 60px;\n  padding-bottom: 0;\n  padding-top: 0;\n  position: relative;\n  box-shadow: 0 5px 21px -11px rgba(31, 31, 33, 0.62);\n  border-top: 4px solid #639fab; }\n.navbar .navbar-brand {\n    font-family: \"Source Code Pro\", monospace !important;\n    font-size: 1.8rem;\n    font-weight: 700; }\n.navbar .container {\n    width: 88vw;\n    min-height: 100px; }\n.navbar .container .nav-link {\n      font-size: 1rem;\n      letter-spacing: 0;\n      cursor: pointer;\n      color: rgba(255, 251, 254, 0.5);\n      font-weight: 700; }\n.navbar .container .nav-link:hover {\n        color: white; }\n.navbar .container .active {\n      border-bottom: 2px solid #639fab;\n      color: white; }\n.dropdown-toggle::after {\n  display: none; }\n.login {\n  padding-right: 1rem;\n  color: #f1f1f1; }\n@media screen and (max-width: 700px) {\n    .login {\n      display: none; } }\nimg {\n  max-width: 50px;\n  border-radius: 50px;\n  margin: 0;\n  cursor: pointer;\n  opacity: .95; }\nimg:hover {\n    opacity: 1; }\n#user-options {\n  margin-top: .5rem;\n  font-family: \"Open Sans\", sans-serif; }\n#user-options .dropdown-item {\n    cursor: pointer; }\n#user-options .dropdown-item:hover {\n      background-color: #3e505b;\n      color: #fffbfe; }\n.btn-secondary {\n  font-weight: 500; }\n#user-info {\n  color: #fffbfe;\n  margin-left: 1rem;\n  margin-right: .5rem; }\n#user-info #login {\n    opacity: 0;\n    width: 1px;\n    transition: .75s ease; }\n#user-info img {\n    margin-left: .5rem; }\n#user-info:hover #login {\n    opacity: 1;\n    width: -webkit-fit-content;\n    width: -moz-fit-content;\n    width: fit-content;\n    transition: all .75s ease; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvbmF2YmFyL25hdmJhci5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSw0RUFBWTtBQ0NaO0VBQ0UscUNBQXdDO0VBQ3hDLGlCQUFnQjtFQUNoQixzQ0FBcUM7RUFDckMsaUJBQWdCO0VBQ2hCLGtCQUFpQjtFQUNqQixlQUFjO0VBQ2QsbUJBQWtCO0VBQ2xCLG9EQUFtRDtFQUNuRCw4QkRKbUMsRUNpQ3BDO0FBdENEO0lBWUkscURBQXlDO0lBQ3pDLGtCQUFpQjtJQUNqQixpQkFBZ0IsRUFDakI7QUFmSDtJQWtCSSxZQUFXO0lBQ1gsa0JBQWlCLEVBa0JsQjtBQXJDSDtNQXNCTSxnQkFBZTtNQUNmLGtCQUFpQjtNQUNqQixnQkFBZTtNQUNmLGdDQUE4QjtNQUM5QixpQkFBZ0IsRUFLakI7QUEvQkw7UUE2QlEsYUFBWSxFQUNiO0FBOUJQO01BaUNNLGlDRDVCK0I7TUM2Qi9CLGFBQVksRUFFYjtBQUlMO0VBQ0UsY0FBYSxFQUNkO0FBRUQ7RUFDRSxvQkFBbUI7RUFDbkIsZUFBYyxFQUtmO0FBSEM7SUFKRjtNQUtJLGNBQWEsRUFFaEIsRUFBQTtBQUVEO0VBQ0UsZ0JBQWU7RUFDZixvQkFBbUI7RUFDbkIsVUFBUztFQUNULGdCQUFlO0VBQ2YsYUFBWSxFQUtiO0FBVkQ7SUFRSSxXQUFVLEVBQ1g7QUFHSDtFQUNFLGtCQUFpQjtFQUNqQixxQ0QxRDZDLEVDbUU5QztBQVhEO0lBSUksZ0JBQWUsRUFNaEI7QUFWSDtNQU9NLDBCRHJFZ0I7TUNzRWhCLGVEdkVtQyxFQ3dFcEM7QUFJTDtFQUNFLGlCQUFnQixFQUNqQjtBQUVEO0VBQ0UsZURqRnVDO0VDa0Z2QyxrQkFBaUI7RUFDakIsb0JBQW1CLEVBbUJwQjtBQXRCRDtJQU1JLFdBQVU7SUFDVixXQUFVO0lBQ1Ysc0JBQXFCLEVBQ3RCO0FBVEg7SUFZSSxtQkFBa0IsRUFDbkI7QUFiSDtJQWlCTSxXQUFVO0lBQ1YsMkJBQWtCO0lBQWxCLHdCQUFrQjtJQUFsQixtQkFBa0I7SUFDbEIsMEJBQXlCLEVBQzFCIiwiZmlsZSI6InNyYy9hcHAvbmF2YmFyL25hdmJhci5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi8vJGRhcms6IHJnYigyNSwgMjMsIDIyKTtcbkBpbXBvcnQgdXJsKCdodHRwczovL2ZvbnRzLmdvb2dsZWFwaXMuY29tL2Nzcz9mYW1pbHk9TW9udHNlcnJhdHxPcGVuK1NhbnMnKTtcblxuJGRhcms6IHJnYigyOCwgMzUsIDQ5KTtcbiRiYWNrZ3JvdW5kLWxpZ2h0OiByZ2JhKDI1NSwgMjUxLCAyNTQsIDEpO1xuJGJsdWU6IHJnYig2MiwgODAsIDkxKTtcbiRwcmltYXJ5OiAkYmx1ZTtcbiRwcmltYXJ5LWhvdmVyOiByZ2JhKDk5LCAxNTksIDE3MSwgMSk7XG4kbGlnaHQtZ3JheS1saW5lLWJvcmRlcjogI2U2ZTZlNiAycHggc29saWQ7XG4kYmctZ3JheTogI2U2ZTZlNjtcbiRmb250LWZhbWlseS1wcmltYXJ5OiAnTW9udHNlcnJhdCcsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktc2Vjb25kYXJ5OiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LXNpemUtYmFzZTogMXJlbTtcbiRmb250LWZhbWlseS1iYXNlOiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1jb2RlOiAnU291cmNlIENvZGUgUHJvJywgbW9ub3NwYWNlO1xuXG4kY29sb3JzOiAoXG4gIHByaW1hcnk6ICRwcmltYXJ5LFxuICBob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGRhcms6ICRkYXJrLFxuICBiZy1saWdodDogJGJhY2tncm91bmQtbGlnaHQsXG4gIHByaW1hcnktaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBiZy1ncmF5OiAkYmctZ3JheVxuKTtcblxuQGZ1bmN0aW9uIGNvbG9yKCRjb2xvcikge1xuICBAcmV0dXJuIG1hcC1nZXQoJGNvbG9ycywgJGNvbG9yKVxufVxuXG4kdGhlbWUtY29sb3JzOiAoXG4gIFwicHJpbWFyeVwiOiAkcHJpbWFyeSxcbiAgXCJwcmltYXJ5LWhvdmVyXCI6ICRwcmltYXJ5LWhvdmVyXG4pO1xuXG5cbi5jb250YWluZXItZmx1aWQge1xuXG59XG4iLCJAaW1wb3J0IFwifnNyYy92YXJpYWJsZXNcIjtcblxuLm5hdmJhciB7XG4gIGJhY2tncm91bmQtY29sb3I6IGNvbG9yKGRhcmspICFpbXBvcnRhbnQ7XG4gIGZvbnQtc2l6ZTogLjlyZW07XG4gIGZvbnQtZmFtaWx5OiAnTW9udHNlcnJhdCcsIHNhbnMtc2VyaWY7XG4gIG1pbi1oZWlnaHQ6IDYwcHg7XG4gIHBhZGRpbmctYm90dG9tOiAwO1xuICBwYWRkaW5nLXRvcDogMDtcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xuICBib3gtc2hhZG93OiAwIDVweCAyMXB4IC0xMXB4IHJnYmEoMzEsIDMxLCAzMywgMC42Mik7XG4gIGJvcmRlci10b3A6IDRweCBzb2xpZCBjb2xvcihwcmltYXJ5LWhvdmVyKTtcblxuICAubmF2YmFyLWJyYW5kIHtcbiAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LWNvZGUgIWltcG9ydGFudDtcbiAgICBmb250LXNpemU6IDEuOHJlbTtcbiAgICBmb250LXdlaWdodDogNzAwO1xuICB9XG5cbiAgLmNvbnRhaW5lciB7XG4gICAgd2lkdGg6IDg4dnc7XG4gICAgbWluLWhlaWdodDogMTAwcHg7XG5cbiAgICAubmF2LWxpbmsge1xuICAgICAgZm9udC1zaXplOiAxcmVtO1xuICAgICAgbGV0dGVyLXNwYWNpbmc6IDA7XG4gICAgICBjdXJzb3I6IHBvaW50ZXI7XG4gICAgICBjb2xvcjogcmdiYSgyNTUsIDI1MSwgMjU0LCAuNSk7XG4gICAgICBmb250LXdlaWdodDogNzAwO1xuXG4gICAgICAmOmhvdmVyIHtcbiAgICAgICAgY29sb3I6IHdoaXRlO1xuICAgICAgfVxuICAgIH1cbiAgICAuYWN0aXZlIHtcbiAgICAgIGJvcmRlci1ib3R0b206IDJweCBzb2xpZCBjb2xvcihwcmltYXJ5LWhvdmVyKTtcbiAgICAgIGNvbG9yOiB3aGl0ZTtcblxuICAgIH1cbiAgfVxufVxuXG4uZHJvcGRvd24tdG9nZ2xlOjphZnRlciB7XG4gIGRpc3BsYXk6IG5vbmU7XG59XG5cbi5sb2dpbiB7XG4gIHBhZGRpbmctcmlnaHQ6IDFyZW07XG4gIGNvbG9yOiAjZjFmMWYxO1xuXG4gIEBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6IDcwMHB4KSB7XG4gICAgZGlzcGxheTogbm9uZTtcbiAgfVxufVxuXG5pbWcge1xuICBtYXgtd2lkdGg6IDUwcHg7XG4gIGJvcmRlci1yYWRpdXM6IDUwcHg7XG4gIG1hcmdpbjogMDtcbiAgY3Vyc29yOiBwb2ludGVyO1xuICBvcGFjaXR5OiAuOTU7XG5cbiAgJjpob3ZlciB7XG4gICAgb3BhY2l0eTogMTtcbiAgfVxufVxuXG4jdXNlci1vcHRpb25zIHtcbiAgbWFyZ2luLXRvcDogLjVyZW07XG4gIGZvbnQtZmFtaWx5OiAkZm9udC1mYW1pbHktc2Vjb25kYXJ5O1xuICAuZHJvcGRvd24taXRlbSB7XG4gICAgY3Vyc29yOiBwb2ludGVyO1xuXG4gICAgJjpob3ZlciB7XG4gICAgICBiYWNrZ3JvdW5kLWNvbG9yOiAkcHJpbWFyeTtcbiAgICAgIGNvbG9yOiAkYmFja2dyb3VuZC1saWdodDtcbiAgICB9XG4gIH1cbn1cblxuLmJ0bi1zZWNvbmRhcnkge1xuICBmb250LXdlaWdodDogNTAwO1xufVxuXG4jdXNlci1pbmZvIHtcbiAgY29sb3I6ICRiYWNrZ3JvdW5kLWxpZ2h0O1xuICBtYXJnaW4tbGVmdDogMXJlbTtcbiAgbWFyZ2luLXJpZ2h0OiAuNXJlbTtcblxuICAjbG9naW4ge1xuICAgIG9wYWNpdHk6IDA7XG4gICAgd2lkdGg6IDFweDtcbiAgICB0cmFuc2l0aW9uOiAuNzVzIGVhc2U7XG4gIH1cblxuICBpbWcge1xuICAgIG1hcmdpbi1sZWZ0OiAuNXJlbTtcbiAgfVxuXG4gICY6aG92ZXIge1xuICAgICNsb2dpbiB7XG4gICAgICBvcGFjaXR5OiAxO1xuICAgICAgd2lkdGg6IGZpdC1jb250ZW50O1xuICAgICAgdHJhbnNpdGlvbjogYWxsIC43NXMgZWFzZTtcbiAgICB9XG4gIH1cbn1cblxuIl19 */"

/***/ }),

/***/ "./src/app/navbar/navbar.component.ts":
/*!********************************************!*\
  !*** ./src/app/navbar/navbar.component.ts ***!
  \********************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../shared/auth.service */ "./src/app/shared/auth.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(auth) {
        this.auth = auth;
        this.collapsed = true;
    }
    NavbarComponent.prototype.login = function () {
        window.location.href = 'http://localhost:8080/oauth2/authorization/github';
    };
    NavbarComponent.prototype.ngOnInit = function () {
        this.auth.authenticate();
    };
    NavbarComponent.prototype.logout = function () {
        this.auth.logout()
            .subscribe(function (status) { return console.log(status); }, function (err) { return console.log(err); });
    };
    NavbarComponent.prototype.ngOnDestroy = function () { };
    NavbarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.scss */ "./src/app/navbar/navbar.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/project/project-card/project-card.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"project-card-wrapper\" style=\"margin-right: 2rem; margin-left: 2rem;\">\n\n  <div class=\"container \" id=\"vote\">\n    <button [disabled]=\"!auth.authenticated\" id=\"upvote-btn\" (click)=\"upVote()\" class=\"vote-button fa fa-arrow-up fa-1x\"></button>\n    <div id=\"upvote-count\">{{project?.rating}}</div>\n    <button [disabled]=\"!auth.authenticated\" id=\"downvote-btn\" (click)=\"downVote()\" class=\"vote-button fa fa-arrow-down fa-1x\"></button>\n  </div>\n\n  <div id=\"project-card\" class=\"container\">\n    <h4><a class=\"title\" (click)=\"getDetails()\">{{project?.title}}</a>\n    </h4>\n    <span id=\"difficulty\" class=\"pl-2 font-weight-bold\" [style.color]=\"service.setColor(project?.difficulty)\">\n      [{{project?.difficulty | uppercase }}]</span>\n    <div id=\"preview-content\">\n      <!-- todo add tags like stack overflow -->\n      <div class=\"text-body\" id=\"description\">{{project?.description | ellipsis:500 }}</div>\n      <a class=\"read-more text-center\" (click)=\"getDetails()\">Read more</a>\n    </div>\n    <hr class=\"my-2\">\n    <h6 id=\"metadata\">\n      <span class=\"user-details\">\n        <img src=\"{{project?.author.avatar_url}}\" class=\"avatar\">\n        {{project?.author.login}}</span>\n      <span class=\"date\"><i class=\"fa fa-calendar-o\"></i> {{project?.date_posted | date: 'MMM. d, y'}}</span>\n    </h6>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-card/project-card.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n.project-card-wrapper {\n  display: grid;\n  grid-template-columns: 2rem auto;\n  margin-top: 4rem; }\n.project-card-wrapper #vote {\n    display: grid;\n    grid-template-rows: repeat(3, 2rem);\n    margin-top: .5rem;\n    color: lightgray;\n    justify-content: center; }\n.project-card-wrapper #vote .vote-button {\n      background-color: transparent;\n      border: none;\n      color: inherit;\n      outline: none; }\n.project-card-wrapper #vote .vote-button:not(:disabled) {\n        cursor: pointer; }\n.project-card-wrapper #vote .vote-button:not(:disabled):hover {\n          color: #639fab; }\n.project-card-wrapper #vote #upvote-count {\n      justify-self: center !important; }\n.project-card-wrapper #project-card {\n    border-radius: 5px; }\n.project-card-wrapper #project-card .title {\n      color: #1c2331;\n      font-family: \"Montserrat\", sans-serif;\n      font-weight: 700;\n      font-size: 1.4rem; }\n.project-card-wrapper #project-card .title:hover {\n        color: #639fab;\n        cursor: pointer; }\n.project-card-wrapper #project-card #preview-content {\n      margin-top: 1rem;\n      margin-left: 1.2rem; }\n.project-card-wrapper #project-card #preview-content #description {\n        font-size: 1rem;\n        line-height: 24px;\n        word-wrap: break-spaces;\n        white-space: pre-wrap;\n        padding-bottom: 2rem;\n        font-family: \"Open Sans\", sans-serif; }\n.project-card-wrapper #project-card #preview-content .read-more {\n        align-self: center;\n        cursor: pointer;\n        font-size: 1rem;\n        font-weight: 500;\n        color: #3e505b;\n        padding-bottom: 1rem; }\n.project-card-wrapper #project-card #preview-content .read-more:hover {\n          color: #639fab; }\n.project-card-wrapper #project-card #metadata {\n      font-size: .9rem;\n      padding-top: .5rem;\n      display: grid;\n      grid-template-columns: repeat(2, auto); }\n.project-card-wrapper #project-card #metadata .user-details {\n        justify-self: left; }\n.project-card-wrapper #project-card #metadata .user-details .avatar {\n          max-height: 20px;\n          box-shadow: 0 0 .1rem black;\n          border-radius: 50px; }\n.project-card-wrapper #project-card #metadata .date {\n        justify-self: right; }\n.project-card-wrapper #project-card #difficulty {\n      color: gray;\n      padding-bottom: 1rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvcHJvamVjdC9wcm9qZWN0LWNhcmQvcHJvamVjdC1jYXJkLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNBLDRFQUFZO0FDQ1o7RUFDRSxjQUFhO0VBQ2IsaUNBQWdDO0VBQ2hDLGlCQUFnQixFQXFHakI7QUF4R0Q7SUFNSSxjQUFhO0lBQ2Isb0NBQW1DO0lBQ25DLGtCQUFpQjtJQUNqQixpQkFBZ0I7SUFDaEIsd0JBQXVCLEVBdUJ4QjtBQWpDSDtNQWFNLDhCQUE2QjtNQUM3QixhQUFZO01BQ1osZUFBYztNQUNkLGNBQWEsRUFTZDtBQXpCTDtRQW1CUSxnQkFBZSxFQUtoQjtBQXhCUDtVQXNCVSxlRGpCMkIsRUNrQjVCO0FBdkJUO01BK0JNLGdDQUErQixFQUNoQztBQWhDTDtJQW9DSSxtQkFBa0IsRUFtRW5CO0FBdkdIO01BdUNNLGVEdENnQjtNQ3VDaEIsc0NEaEN3QztNQ2lDeEMsaUJBQWdCO01BQ2hCLGtCQUFpQixFQU1sQjtBQWhETDtRQTZDUSxlRHhDNkI7UUN5QzdCLGdCQUFlLEVBQ2hCO0FBL0NQO01BbURNLGlCQUFnQjtNQUNoQixvQkFBbUIsRUF3QnBCO0FBNUVMO1FBdURRLGdCQUFlO1FBQ2Ysa0JBQWlCO1FBQ2pCLHdCQUF1QjtRQUN2QixzQkFBcUI7UUFDckIscUJBQW9CO1FBQ3BCLHFDRG5EdUMsRUNxRHhDO0FBOURQO1FBaUVRLG1CQUFrQjtRQUNsQixnQkFBZTtRQUNmLGdCQUFlO1FBQ2YsaUJBQWdCO1FBQ2hCLGVEbEVjO1FDbUVkLHFCQUFvQixFQUtyQjtBQTNFUDtVQXlFVSxlRHBFMkIsRUNxRTVCO0FBMUVUO01BK0VNLGlCQUFnQjtNQUNoQixtQkFBa0I7TUFDbEIsY0FBYTtNQUNiLHVDQUFzQyxFQWV2QztBQWpHTDtRQXFGUSxtQkFBa0IsRUFPbkI7QUE1RlA7VUF3RlUsaUJBQWdCO1VBQ2hCLDRCQUEyQjtVQUMzQixvQkFBbUIsRUFDcEI7QUEzRlQ7UUErRlEsb0JBQW1CLEVBQ3BCO0FBaEdQO01Bb0dNLFlBQVc7TUFDWCxxQkFBb0IsRUFDckIiLCJmaWxlIjoic3JjL2FwcC9wcm9qZWN0L3Byb2plY3QtY2FyZC9wcm9qZWN0LWNhcmQuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvLyRkYXJrOiByZ2IoMjUsIDIzLCAyMik7XG5AaW1wb3J0IHVybCgnaHR0cHM6Ly9mb250cy5nb29nbGVhcGlzLmNvbS9jc3M/ZmFtaWx5PU1vbnRzZXJyYXR8T3BlbitTYW5zJyk7XG5cbiRkYXJrOiByZ2IoMjgsIDM1LCA0OSk7XG4kYmFja2dyb3VuZC1saWdodDogcmdiYSgyNTUsIDI1MSwgMjU0LCAxKTtcbiRibHVlOiByZ2IoNjIsIDgwLCA5MSk7XG4kcHJpbWFyeTogJGJsdWU7XG4kcHJpbWFyeS1ob3ZlcjogcmdiYSg5OSwgMTU5LCAxNzEsIDEpO1xuJGxpZ2h0LWdyYXktbGluZS1ib3JkZXI6ICNlNmU2ZTYgMnB4IHNvbGlkO1xuJGJnLWdyYXk6ICNlNmU2ZTY7XG4kZm9udC1mYW1pbHktcHJpbWFyeTogJ01vbnRzZXJyYXQnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LXNlY29uZGFyeTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1zaXplLWJhc2U6IDFyZW07XG4kZm9udC1mYW1pbHktYmFzZTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktY29kZTogJ1NvdXJjZSBDb2RlIFBybycsIG1vbm9zcGFjZTtcblxuJGNvbG9yczogKFxuICBwcmltYXJ5OiAkcHJpbWFyeSxcbiAgaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBkYXJrOiAkZGFyayxcbiAgYmctbGlnaHQ6ICRiYWNrZ3JvdW5kLWxpZ2h0LFxuICBwcmltYXJ5LWhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgYmctZ3JheTogJGJnLWdyYXlcbik7XG5cbkBmdW5jdGlvbiBjb2xvcigkY29sb3IpIHtcbiAgQHJldHVybiBtYXAtZ2V0KCRjb2xvcnMsICRjb2xvcilcbn1cblxuJHRoZW1lLWNvbG9yczogKFxuICBcInByaW1hcnlcIjogJHByaW1hcnksXG4gIFwicHJpbWFyeS1ob3ZlclwiOiAkcHJpbWFyeS1ob3ZlclxuKTtcblxuXG4uY29udGFpbmVyLWZsdWlkIHtcblxufVxuIiwiQGltcG9ydCBcIn5zcmMvX3ZhcmlhYmxlcy5zY3NzXCI7XG5cbi5wcm9qZWN0LWNhcmQtd3JhcHBlciB7XG4gIGRpc3BsYXk6IGdyaWQ7XG4gIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMnJlbSBhdXRvO1xuICBtYXJnaW4tdG9wOiA0cmVtO1xuXG4gICN2b3RlIHtcbiAgICBkaXNwbGF5OiBncmlkO1xuICAgIGdyaWQtdGVtcGxhdGUtcm93czogcmVwZWF0KDMsIDJyZW0pO1xuICAgIG1hcmdpbi10b3A6IC41cmVtO1xuICAgIGNvbG9yOiBsaWdodGdyYXk7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG5cbiAgICAudm90ZS1idXR0b24ge1xuICAgICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG4gICAgICBib3JkZXI6IG5vbmU7XG4gICAgICBjb2xvcjogaW5oZXJpdDtcbiAgICAgIG91dGxpbmU6IG5vbmU7XG5cbiAgICAgICY6bm90KDpkaXNhYmxlZCkge1xuICAgICAgICBjdXJzb3I6IHBvaW50ZXI7XG5cbiAgICAgICAgJjpob3ZlciB7XG4gICAgICAgICAgY29sb3I6ICRwcmltYXJ5LWhvdmVyO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuXG4gICAgI3Vwdm90ZS1idG57XG4gICAgfVxuXG4gICAgI3Vwdm90ZS1jb3VudCB7XG4gICAgICBqdXN0aWZ5LXNlbGY6IGNlbnRlciAhaW1wb3J0YW50O1xuICAgIH1cbiAgfVxuXG4gICNwcm9qZWN0LWNhcmQge1xuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcblxuICAgIC50aXRsZSB7XG4gICAgICBjb2xvcjogJGRhcms7XG4gICAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXByaW1hcnk7XG4gICAgICBmb250LXdlaWdodDogNzAwO1xuICAgICAgZm9udC1zaXplOiAxLjRyZW07XG5cbiAgICAgICY6aG92ZXIge1xuICAgICAgICBjb2xvcjogJHByaW1hcnktaG92ZXI7XG4gICAgICAgIGN1cnNvcjogcG9pbnRlcjtcbiAgICAgIH1cbiAgICB9XG5cbiAgICAjcHJldmlldy1jb250ZW50IHtcbiAgICAgIG1hcmdpbi10b3A6IDFyZW07XG4gICAgICBtYXJnaW4tbGVmdDogMS4ycmVtO1xuXG4gICAgICAjZGVzY3JpcHRpb24ge1xuICAgICAgICBmb250LXNpemU6IDFyZW07XG4gICAgICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICAgICAgICB3b3JkLXdyYXA6IGJyZWFrLXNwYWNlcztcbiAgICAgICAgd2hpdGUtc3BhY2U6IHByZS13cmFwO1xuICAgICAgICBwYWRkaW5nLWJvdHRvbTogMnJlbTtcbiAgICAgICAgZm9udC1mYW1pbHk6ICRmb250LWZhbWlseS1zZWNvbmRhcnk7XG5cbiAgICAgIH1cblxuICAgICAgLnJlYWQtbW9yZSB7XG4gICAgICAgIGFsaWduLXNlbGY6IGNlbnRlcjtcbiAgICAgICAgY3Vyc29yOiBwb2ludGVyO1xuICAgICAgICBmb250LXNpemU6IDFyZW07XG4gICAgICAgIGZvbnQtd2VpZ2h0OiA1MDA7XG4gICAgICAgIGNvbG9yOiAkYmx1ZTtcbiAgICAgICAgcGFkZGluZy1ib3R0b206IDFyZW07XG5cbiAgICAgICAgJjpob3ZlciB7XG4gICAgICAgICAgY29sb3I6ICRwcmltYXJ5LWhvdmVyO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuXG4gICAgI21ldGFkYXRhIHtcbiAgICAgIGZvbnQtc2l6ZTogLjlyZW07XG4gICAgICBwYWRkaW5nLXRvcDogLjVyZW07XG4gICAgICBkaXNwbGF5OiBncmlkO1xuICAgICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiByZXBlYXQoMiwgYXV0byk7XG5cbiAgICAgIC51c2VyLWRldGFpbHMge1xuICAgICAgICBqdXN0aWZ5LXNlbGY6IGxlZnQ7XG5cbiAgICAgICAgLmF2YXRhciB7XG4gICAgICAgICAgbWF4LWhlaWdodDogMjBweDtcbiAgICAgICAgICBib3gtc2hhZG93OiAwIDAgLjFyZW0gYmxhY2s7XG4gICAgICAgICAgYm9yZGVyLXJhZGl1czogNTBweDtcbiAgICAgICAgfVxuICAgICAgfVxuXG4gICAgICAuZGF0ZSB7XG4gICAgICAgIGp1c3RpZnktc2VsZjogcmlnaHQ7XG4gICAgICB9XG4gICAgfVxuXG4gICAgI2RpZmZpY3VsdHkge1xuICAgICAgY29sb3I6IGdyYXk7XG4gICAgICBwYWRkaW5nLWJvdHRvbTogMXJlbTtcbiAgICB9XG4gIH1cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/project/project-card/project-card.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectCardComponent", function() { return ProjectCardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _shared_vote_enum__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../shared/vote.enum */ "./src/app/shared/vote.enum.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ProjectCardComponent = /** @class */ (function () {
    function ProjectCardComponent(service, auth, router) {
        this.service = service;
        this.auth = auth;
        this.router = router;
    }
    ProjectCardComponent.prototype.ngOnInit = function () {
    };
    ProjectCardComponent.prototype.getDetails = function () {
        this.router.navigate(['projects', this.project.id])
            .catch(function (err) { return console.error(err.message); });
    };
    ProjectCardComponent.prototype.upVote = function () {
        this.project.rating++;
        this.service.voteOnProject(_shared_vote_enum__WEBPACK_IMPORTED_MODULE_4__["Vote"].UPVOTE, this.project.id);
    };
    ProjectCardComponent.prototype.downVote = function () {
        this.project.rating--;
        this.service.voteOnProject(_shared_vote_enum__WEBPACK_IMPORTED_MODULE_4__["Vote"].DOWNVOTE, this.project.id);
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ProjectCardComponent.prototype, "project", void 0);
    ProjectCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-card',
            template: __webpack_require__(/*! ./project-card.component.html */ "./src/app/project/project-card/project-card.component.html"),
            styles: [__webpack_require__(/*! ./project-card.component.scss */ "./src/app/project/project-card/project-card.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_3__["ProjectService"], _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ProjectCardComponent);
    return ProjectCardComponent;
}());



/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"project?.title || 'Project Details'\"></app-header>\n\n\n\n\n\n  <div class=\"container-fluid details-page\">\n    <div id=\"project-details\" class=\"container\">\n\n      <div id=\"details-header\" >\n        <span class=\"difficulty\"\n              [style.color]=\"projectService.setColor(project?.difficulty)\">[{{project?.difficulty | uppercase}}]</span>\n        <span class=\"date\"><i class=\"fa fa-calendar-o\"></i>\n          {{project?.date_posted | date: 'short' }}\n        </span>\n\n        <div class=\"metadata\">\n        <span id=\"user-info\" class=\"container\">\n          <span id=\"submitted-by\">submitted by:  </span>\n          <span class=\"author-login\">{{project?.author?.login}}</span>\n        </span>\n        </div>\n      </div>\n\n      <app-project-edit *ngIf=\"editing\" [project]=\"project\"></app-project-edit>\n\n      <div *ngIf=\"!editing\" class=\"project-description container\">\n        <article class=\"text text-body\" *ngIf=\"!editing\">{{project?.description}}</article>\n      </div>\n      <div class=\"author-buttons\" *ngIf=\"isAuthor() && !editing\" id=\"options\">\n        <button id=\"edit\" (click)=\"edit()\" class=\"btn btn-sm btn-outline-secondary\">\n          <i class=\"fa fa-pencil\"></i> Edit\n        </button>\n\n        <!-- Delete project modal -->\n        <ng-template #projectDeleteModal let-modal>\n          <div class=\"modal-header\">\n            <h5 class=\"modal-title\" id=\"modal-title\">Confirm Deletion</h5>\n          </div>\n          <div class=\"modal-body\" style=\"font-size: 1rem\">\n            <p>Are you sure you want to delete this project? <br>\n              <br>\n              <em>This <strong>cannot</strong> be undone</em>.</p>\n          </div>\n          <div class=\"modal-footer\">\n            <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\" (click)=\"modal.close()\">Cancel</button>\n            <button type=\"button\" class=\"btn btn-sm btn-danger\" (click)=\"deleteProject()\"><i class=\"fa fa-trash-o\"></i>\n              Delete\n            </button>\n          </div>\n        </ng-template>\n        <button id=\"delete\"\n                class=\"btn btn-sm btn-danger\"\n                (click)=\"confirmDelete(projectDeleteModal)\"><i class=\"fa fa-trash-o\"></i> Delete\n        </button>\n        <!-- end of modal -->\n\n    </div>\n      <app-comment-list></app-comment-list>\n  </div>\n</div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.scss":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.scss ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n.details-page {\n  max-width: 90%; }\n.details-page #project-details #details-header {\n    padding-bottom: 1rem; }\n.details-page #project-details #details-header .title {\n      font-family: \"Montserrat\", sans-serif;\n      font-weight: 600;\n      font-size: 1.5rem;\n      margin-bottom: 1rem; }\n.details-page #project-details #details-header .difficulty {\n      padding-left: 1rem; }\n.details-page #project-details #details-header .date {\n      justify-self: end;\n      font-size: .9rem;\n      float: right; }\n.details-page #project-details .metadata {\n    margin: 0;\n    display: grid; }\n.details-page #project-details .metadata .difficulty {\n      font-size: 1.2rem;\n      padding-left: 1rem;\n      color: gray;\n      font-family: \"Open Sans\", sans-serif; }\n.details-page #project-details .metadata #user-info {\n      font-size: 1rem;\n      justify-self: start; }\n.details-page #project-details .metadata #user-info .author-avatar img {\n        max-height: 20px;\n        max-width: 20px;\n        border-radius: 50px; }\n.details-page #project-details .metadata #user-info .author-login {\n        padding-left: .3rem;\n        font-size: 1rem; }\n.details-page #project-details .project-description {\n    margin-top: 1.5rem;\n    white-space: pre-wrap; }\n.details-page #project-details .project-description .text {\n      font-family: \"Open Sans\", sans-serif;\n      font-size: 1rem;\n      word-wrap: break-spaces;\n      padding-bottom: 2rem; }\n.details-page #project-details .author-buttons {\n    max-width: -webkit-fit-content;\n    max-width: -moz-fit-content;\n    max-width: fit-content;\n    float: right; }\n.details-page #project-details .author-buttons #delete {\n      margin-left: .5rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvcHJvamVjdC9wcm9qZWN0LWRldGFpbC9wcm9qZWN0LWRldGFpbC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSw0RUFBWTtBQ0NaO0VBQ0EsZUFBYyxFQStFYjtBQWhGRDtJQU1NLHFCQUFvQixFQWtCckI7QUF4Qkw7TUFTUSxzQ0REc0M7TUNFdEMsaUJBQWdCO01BQ2hCLGtCQUFpQjtNQUNqQixvQkFBbUIsRUFDcEI7QUFiUDtNQWdCUSxtQkFBa0IsRUFDbkI7QUFqQlA7TUFvQlEsa0JBQWlCO01BQ2pCLGlCQUFnQjtNQUNoQixhQUFZLEVBQ2I7QUF2QlA7SUEyQk0sVUFBUztJQUNULGNBQWEsRUF5QmQ7QUFyREw7TUErQlEsa0JBQWlCO01BQ2pCLG1CQUFrQjtNQUNsQixZQUFXO01BQ1gscUNEekJ1QyxFQzBCeEM7QUFuQ1A7TUFzQ1EsZ0JBQWU7TUFFZixvQkFBbUIsRUFZcEI7QUFwRFA7UUEyQ1UsaUJBQWdCO1FBQ2hCLGdCQUFlO1FBQ2Ysb0JBQW1CLEVBQ3BCO0FBOUNUO1FBaURVLG9CQUFtQjtRQUNuQixnQkFBZSxFQUNoQjtBQW5EVDtJQXdETSxtQkFBa0I7SUFDbEIsc0JBQXFCLEVBUXRCO0FBakVMO01BNERRLHFDRG5EdUM7TUNvRHZDLGdCQUFlO01BQ2Ysd0JBQXVCO01BQ3ZCLHFCQUFvQixFQUNyQjtBQWhFUDtJQW9FTSwrQkFBc0I7SUFBdEIsNEJBQXNCO0lBQXRCLHVCQUFzQjtJQUN0QixhQUFZLEVBUWI7QUE3RUw7TUEyRVEsbUJBQWtCLEVBQ25CIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LWRldGFpbC9wcm9qZWN0LWRldGFpbC5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi8vJGRhcms6IHJnYigyNSwgMjMsIDIyKTtcbkBpbXBvcnQgdXJsKCdodHRwczovL2ZvbnRzLmdvb2dsZWFwaXMuY29tL2Nzcz9mYW1pbHk9TW9udHNlcnJhdHxPcGVuK1NhbnMnKTtcblxuJGRhcms6IHJnYigyOCwgMzUsIDQ5KTtcbiRiYWNrZ3JvdW5kLWxpZ2h0OiByZ2JhKDI1NSwgMjUxLCAyNTQsIDEpO1xuJGJsdWU6IHJnYig2MiwgODAsIDkxKTtcbiRwcmltYXJ5OiAkYmx1ZTtcbiRwcmltYXJ5LWhvdmVyOiByZ2JhKDk5LCAxNTksIDE3MSwgMSk7XG4kbGlnaHQtZ3JheS1saW5lLWJvcmRlcjogI2U2ZTZlNiAycHggc29saWQ7XG4kYmctZ3JheTogI2U2ZTZlNjtcbiRmb250LWZhbWlseS1wcmltYXJ5OiAnTW9udHNlcnJhdCcsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktc2Vjb25kYXJ5OiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LXNpemUtYmFzZTogMXJlbTtcbiRmb250LWZhbWlseS1iYXNlOiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1jb2RlOiAnU291cmNlIENvZGUgUHJvJywgbW9ub3NwYWNlO1xuXG4kY29sb3JzOiAoXG4gIHByaW1hcnk6ICRwcmltYXJ5LFxuICBob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGRhcms6ICRkYXJrLFxuICBiZy1saWdodDogJGJhY2tncm91bmQtbGlnaHQsXG4gIHByaW1hcnktaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBiZy1ncmF5OiAkYmctZ3JheVxuKTtcblxuQGZ1bmN0aW9uIGNvbG9yKCRjb2xvcikge1xuICBAcmV0dXJuIG1hcC1nZXQoJGNvbG9ycywgJGNvbG9yKVxufVxuXG4kdGhlbWUtY29sb3JzOiAoXG4gIFwicHJpbWFyeVwiOiAkcHJpbWFyeSxcbiAgXCJwcmltYXJ5LWhvdmVyXCI6ICRwcmltYXJ5LWhvdmVyXG4pO1xuXG5cbi5jb250YWluZXItZmx1aWQge1xuXG59XG4iLCJAaW1wb3J0IFwifnNyYy9fdmFyaWFibGVzLnNjc3NcIjtcblxuLmRldGFpbHMtcGFnZSB7XG5tYXgtd2lkdGg6IDkwJTtcblxuICAjcHJvamVjdC1kZXRhaWxzIHtcblxuICAgICNkZXRhaWxzLWhlYWRlciB7XG4gICAgICBwYWRkaW5nLWJvdHRvbTogMXJlbTtcblxuICAgICAgLnRpdGxlIHtcbiAgICAgICAgZm9udC1mYW1pbHk6ICRmb250LWZhbWlseS1wcmltYXJ5O1xuICAgICAgICBmb250LXdlaWdodDogNjAwO1xuICAgICAgICBmb250LXNpemU6IDEuNXJlbTtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogMXJlbTtcbiAgICAgIH1cblxuICAgICAgLmRpZmZpY3VsdHkge1xuICAgICAgICBwYWRkaW5nLWxlZnQ6IDFyZW07XG4gICAgICB9XG5cbiAgICAgIC5kYXRlIHtcbiAgICAgICAganVzdGlmeS1zZWxmOiBlbmQ7XG4gICAgICAgIGZvbnQtc2l6ZTogLjlyZW07XG4gICAgICAgIGZsb2F0OiByaWdodDtcbiAgICAgIH1cbiAgICB9XG5cbiAgICAubWV0YWRhdGEge1xuICAgICAgbWFyZ2luOiAwO1xuICAgICAgZGlzcGxheTogZ3JpZDtcblxuICAgICAgLmRpZmZpY3VsdHkge1xuICAgICAgICBmb250LXNpemU6IDEuMnJlbTtcbiAgICAgICAgcGFkZGluZy1sZWZ0OiAxcmVtO1xuICAgICAgICBjb2xvcjogZ3JheTtcbiAgICAgICAgZm9udC1mYW1pbHk6ICRmb250LWZhbWlseS1zZWNvbmRhcnk7XG4gICAgICB9XG5cbiAgICAgICN1c2VyLWluZm8ge1xuICAgICAgICBmb250LXNpemU6IDFyZW07XG5cbiAgICAgICAganVzdGlmeS1zZWxmOiBzdGFydDtcblxuICAgICAgICAuYXV0aG9yLWF2YXRhciBpbWcge1xuICAgICAgICAgIG1heC1oZWlnaHQ6IDIwcHg7XG4gICAgICAgICAgbWF4LXdpZHRoOiAyMHB4O1xuICAgICAgICAgIGJvcmRlci1yYWRpdXM6IDUwcHg7XG4gICAgICAgIH1cblxuICAgICAgICAuYXV0aG9yLWxvZ2luIHtcbiAgICAgICAgICBwYWRkaW5nLWxlZnQ6IC4zcmVtO1xuICAgICAgICAgIGZvbnQtc2l6ZTogMXJlbTtcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cblxuICAgIC5wcm9qZWN0LWRlc2NyaXB0aW9uIHtcbiAgICAgIG1hcmdpbi10b3A6IDEuNXJlbTtcbiAgICAgIHdoaXRlLXNwYWNlOiBwcmUtd3JhcDtcblxuICAgICAgLnRleHQge1xuICAgICAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXNlY29uZGFyeTtcbiAgICAgICAgZm9udC1zaXplOiAxcmVtO1xuICAgICAgICB3b3JkLXdyYXA6IGJyZWFrLXNwYWNlcztcbiAgICAgICAgcGFkZGluZy1ib3R0b206IDJyZW07XG4gICAgICB9XG4gICAgfVxuXG4gICAgLmF1dGhvci1idXR0b25zIHtcbiAgICAgIG1heC13aWR0aDogZml0LWNvbnRlbnQ7XG4gICAgICBmbG9hdDogcmlnaHQ7XG5cbiAgICAgICNlZGl0IHtcbiAgICAgIH1cblxuICAgICAgI2RlbGV0ZSB7XG4gICAgICAgIG1hcmdpbi1sZWZ0OiAuNXJlbTtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxufVxuXG4iXX0= */"

/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.ts ***!
  \********************************************************************/
/*! exports provided: ProjectDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectDetailComponent", function() { return ProjectDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var ProjectDetailComponent = /** @class */ (function () {
    function ProjectDetailComponent(projectService, route, auth, router, projectList, modalService) {
        var _this = this;
        this.projectService = projectService;
        this.route = route;
        this.auth = auth;
        this.router = router;
        this.projectList = projectList;
        this.modalService = modalService;
        this.destroy = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
        this.route.params.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["takeUntil"])(this.destroy))
            .subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    }
    ProjectDetailComponent.prototype.isAuthor = function () {
        if (this.auth.currentUser == null || this.project == null) {
            return false;
        }
        return this.auth.currentUser.id === this.project.author.id;
    };
    ProjectDetailComponent.prototype.deleteProject = function () {
        var _this = this;
        if (this.isAuthor()) {
            this.projectService.deleteProject(this.projectId)
                .subscribe(function (status) { return console.log(status); }, function (err) { return console.log(err); }, function () {
                _this.modalService.dismissAll();
                _this.projectList.ngOnInit();
            })
                .add(function () { return _this.router.navigate(['projects']); });
        }
    };
    ProjectDetailComponent.prototype.confirmDelete = function (content) {
        this.modalService.open(content, { centered: true });
    };
    ProjectDetailComponent.prototype.ngOnInit = function () {
        this.fetchProject();
    };
    ProjectDetailComponent.prototype.edit = function () {
        this.editing = true;
    };
    ProjectDetailComponent.prototype.fetchProject = function () {
        var _this = this;
        this.projectService.fetchById(this.projectId)
            .subscribe(function (data) { return _this.project = data; }, function (err) { return console.error(err.message); });
    };
    ProjectDetailComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-detail',
            template: __webpack_require__(/*! ./project-detail.component.html */ "./src/app/project/project-detail/project-detail.component.html"),
            styles: [__webpack_require__(/*! ./project-detail.component.scss */ "./src/app/project/project-detail/project-detail.component.scss")],
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_1__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_4__["ProjectListComponent"],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__["NgbModal"]])
    ], ProjectDetailComponent);
    return ProjectDetailComponent;
}());



/***/ }),

/***/ "./src/app/project/project-edit/project-edit.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-edit/project-edit.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n  <form (ngSubmit)=\"editProject()\" #projectEditForm=\"ngForm\">\n    <div class=\"form-group\">\n      <label for=\"difficulty\">Change difficulty</label>\n      <select class=\"custom-select\" id=\"difficulty\" required\n              [(ngModel)]=\"project.difficulty\" name=\"difficulty\">\n        <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n      </select>\n    </div>\n    <label for=\"description\">Edit description</label>\n    <textarea type=\"text\" class=\"form-control\"\n              id=\"description\"\n              [(ngModel)]=\"project.description\" name=\"description\" #description=\"ngModel\"\n              rows=\"5\" >{{project?.description}}</textarea>\n    <div class=\"form-group edit-buttons btn-group\">\n      <button type=\"submit\"\n              class=\"btn btn-sm btn-primary\"><i class=\"fa fa-check\"></i>\n        Save\n      </button>\n      <button id=\"cancel-button\" (click)=\"cancel()\"\n              class=\"btn btn-sm btn-outline-secondary\"><i class=\"fa fa-close\"></i>\n        Cancel\n      </button>\n    </div>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-edit/project-edit.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-edit/project-edit.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "form {\n  font-size: 1rem; }\n  form .edit-buttons {\n    display: grid;\n    grid-template-columns: repeat(2, -webkit-min-content);\n    grid-template-columns: repeat(2, min-content);\n    justify-content: right;\n    padding-top: 1rem; }\n  form .edit-buttons #cancel-button {\n      margin-left: .5rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL3Byb2plY3QvcHJvamVjdC1lZGl0L3Byb2plY3QtZWRpdC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGdCQUFlLEVBV2hCO0VBWkQ7SUFHSSxjQUFhO0lBQ2Isc0RBQTZDO0lBQTdDLDhDQUE2QztJQUM3Qyx1QkFBc0I7SUFDdEIsa0JBQWlCLEVBS2xCO0VBWEg7TUFTTSxtQkFBa0IsRUFDbkIiLCJmaWxlIjoic3JjL2FwcC9wcm9qZWN0L3Byb2plY3QtZWRpdC9wcm9qZWN0LWVkaXQuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyJmb3JtIHtcbiAgZm9udC1zaXplOiAxcmVtO1xuICAuZWRpdC1idXR0b25zIHtcbiAgICBkaXNwbGF5OiBncmlkO1xuICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogcmVwZWF0KDIsIG1pbi1jb250ZW50KTtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IHJpZ2h0O1xuICAgIHBhZGRpbmctdG9wOiAxcmVtO1xuXG4gICAgI2NhbmNlbC1idXR0b24ge1xuICAgICAgbWFyZ2luLWxlZnQ6IC41cmVtO1xuICAgIH1cbiAgfVxufVxuIl19 */"

/***/ }),

/***/ "./src/app/project/project-edit/project-edit.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-edit/project-edit.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectEditComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectEditComponent", function() { return ProjectEditComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../project-detail/project-detail.component */ "./src/app/project/project-detail/project-detail.component.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ProjectEditComponent = /** @class */ (function () {
    function ProjectEditComponent(service, projectDetail) {
        this.service = service;
        this.projectDetail = projectDetail;
        this.editing = true;
        this.difficulty = [
            'basic',
            'beginner',
            'intermediate',
            'advanced',
            'expert'
        ];
        this.destroy = new rxjs__WEBPACK_IMPORTED_MODULE_3__["Subject"]();
    }
    ProjectEditComponent.prototype.ngOnInit = function () {
    };
    ProjectEditComponent.prototype.editProject = function () {
        var _this = this;
        return this.service.updateProject(this.project)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeUntil"])(this.destroy))
            .subscribe(function (status) { return console.log(status); }, function (err) { return console.log(err); }, function () { return _this.projectDetail.editing = false; });
    };
    ProjectEditComponent.prototype.cancel = function () {
        this.projectDetail.editing = false;
    };
    ProjectEditComponent.prototype.ngOnDestroy = function () {
        console.log('ProjectEdit destroyed');
        this.destroy.next();
        this.destroy.complete();
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ProjectEditComponent.prototype, "project", void 0);
    ProjectEditComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-edit',
            template: __webpack_require__(/*! ./project-edit.component.html */ "./src/app/project/project-edit/project-edit.component.html"),
            styles: [__webpack_require__(/*! ./project-edit.component.scss */ "./src/app/project/project-edit/project-edit.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_1__["ProjectService"], _project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_2__["ProjectDetailComponent"]])
    ], ProjectEditComponent);
    return ProjectEditComponent;
}());



/***/ }),

/***/ "./src/app/project/project-list/project-list.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid ml-auto page-content\">\n  <app-header [headerText]=\"'Find and share ideas for side projects.'\"></app-header>\n  <div class=\"container-fluid\">\n\n    <app-project-search class=\"ml-5\"></app-project-search>\n\n    <ul class=\"project-list\" *ngIf=\"projectPage\" [@listStagger]=\"projectPage\">\n      <div class=\"list-info container py-0\">\n        <h6 class=\"result-amount\">{{projectPage?.total_elements}} project(s)</h6>\n        <button id=\"post-new\" [disabled]=\"!auth.authenticated\"\n                class=\"post-button btn btn-primary btn-sm text-center\"\n                (click)=\"postForm()\">\n          Post a project\n        </button>\n        <select id=\"order-select\" title=\"order\">\n          <option value=\"new\" (click)=\"ngOnInit()\">newest</option>\n          <option value=\"old\" (click)=\"sortByOldest()\">oldest</option>\n        </select>\n        <ul class=\"pagination-sm\">\n          <li [class]=\"projectPage?.first ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"previousPage()\">prev</a>\n          </li>\n          <li [class]=\"projectPage?.last ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"nextPage()\">next</a>\n          </li>\n        </ul>\n      </div>\n      <li *ngFor=\"let project of projectPage?.content\">\n        <app-project-card [project]=\"project\"></app-project-card>\n      </li>\n    </ul>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-list/project-list.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n@media (min-width: 850px) {\n  .page-content .container-fluid {\n    display: grid;\n    grid-template-columns: 30% auto; } }\n.page-content .container-fluid .project-list {\n  padding-left: 0; }\n@media (min-width: 850px) {\n    .page-content .container-fluid .project-list {\n      border-left: 1px solid lightgray; } }\n.page-content .container-fluid .list-info {\n  display: grid;\n  grid-template-columns: repeat(4, auto);\n  margin-bottom: 1rem;\n  justify-items: center; }\n@media (max-width: 440px) {\n    .page-content .container-fluid .list-info {\n      display: none;\n      margin-bottom: 0; } }\n.page-content .container-fluid .list-info select {\n    margin: 0;\n    width: 6rem;\n    height: 1.3rem;\n    padding: 0;\n    font-size: 1rem; }\n.page-content .container-fluid .list-info .pagination-sm {\n    display: flex; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvcHJvamVjdC9wcm9qZWN0LWxpc3QvcHJvamVjdC1saXN0LmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNBLDRFQUFZO0FDSVI7RUFISjtJQUlRLGNBQWE7SUFDYixnQ0FBK0IsRUFzQ3BDLEVBQUE7QUEzQ0g7RUFTTSxnQkFBZSxFQUloQjtBQUhDO0lBVk47TUFXUSxpQ0FBZ0MsRUFFbkMsRUFBQTtBQWJMO0VBZ0JNLGNBQWE7RUFDYix1Q0FBc0M7RUFDdEMsb0JBQW1CO0VBQ25CLHNCQUFxQixFQXVCdEI7QUF0QkM7SUFwQk47TUFxQlEsY0FBYTtNQUNiLGlCQUFnQixFQW9CbkIsRUFBQTtBQTFDTDtJQTBCUSxVQUFTO0lBQ1QsWUFBVztJQUNYLGVBQWM7SUFDZCxXQUFVO0lBQ1YsZ0JBQWUsRUFDaEI7QUEvQlA7SUF3Q1EsY0FBYSxFQUNkIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LWxpc3QvcHJvamVjdC1saXN0LmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLy8kZGFyazogcmdiKDI1LCAyMywgMjIpO1xuQGltcG9ydCB1cmwoJ2h0dHBzOi8vZm9udHMuZ29vZ2xlYXBpcy5jb20vY3NzP2ZhbWlseT1Nb250c2VycmF0fE9wZW4rU2FucycpO1xuXG4kZGFyazogcmdiKDI4LCAzNSwgNDkpO1xuJGJhY2tncm91bmQtbGlnaHQ6IHJnYmEoMjU1LCAyNTEsIDI1NCwgMSk7XG4kYmx1ZTogcmdiKDYyLCA4MCwgOTEpO1xuJHByaW1hcnk6ICRibHVlO1xuJHByaW1hcnktaG92ZXI6IHJnYmEoOTksIDE1OSwgMTcxLCAxKTtcbiRsaWdodC1ncmF5LWxpbmUtYm9yZGVyOiAjZTZlNmU2IDJweCBzb2xpZDtcbiRiZy1ncmF5OiAjZTZlNmU2O1xuJGZvbnQtZmFtaWx5LXByaW1hcnk6ICdNb250c2VycmF0Jywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1zZWNvbmRhcnk6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtc2l6ZS1iYXNlOiAxcmVtO1xuJGZvbnQtZmFtaWx5LWJhc2U6ICdPcGVuIFNhbnMnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LWNvZGU6ICdTb3VyY2UgQ29kZSBQcm8nLCBtb25vc3BhY2U7XG5cbiRjb2xvcnM6IChcbiAgcHJpbWFyeTogJHByaW1hcnksXG4gIGhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgZGFyazogJGRhcmssXG4gIGJnLWxpZ2h0OiAkYmFja2dyb3VuZC1saWdodCxcbiAgcHJpbWFyeS1ob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGJnLWdyYXk6ICRiZy1ncmF5XG4pO1xuXG5AZnVuY3Rpb24gY29sb3IoJGNvbG9yKSB7XG4gIEByZXR1cm4gbWFwLWdldCgkY29sb3JzLCAkY29sb3IpXG59XG5cbiR0aGVtZS1jb2xvcnM6IChcbiAgXCJwcmltYXJ5XCI6ICRwcmltYXJ5LFxuICBcInByaW1hcnktaG92ZXJcIjogJHByaW1hcnktaG92ZXJcbik7XG5cblxuLmNvbnRhaW5lci1mbHVpZCB7XG5cbn1cbiIsIkBpbXBvcnQgXCJ+c3JjL192YXJpYWJsZXMuc2Nzc1wiO1xuXG4ucGFnZS1jb250ZW50IHtcblxuICAuY29udGFpbmVyLWZsdWlkIHtcbiAgICBAbWVkaWEgKG1pbi13aWR0aDogODUwcHgpIHtcbiAgICAgICAgZGlzcGxheTogZ3JpZDtcbiAgICAgICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiAzMCUgYXV0bztcbiAgICB9XG5cbiAgICAucHJvamVjdC1saXN0IHtcbiAgICAgIHBhZGRpbmctbGVmdDogMDtcbiAgICAgIEBtZWRpYSAobWluLXdpZHRoOiA4NTBweCkge1xuICAgICAgICBib3JkZXItbGVmdDogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcbiAgICAgIH1cbiAgICB9XG5cbiAgICAubGlzdC1pbmZvIHtcbiAgICAgIGRpc3BsYXk6IGdyaWQ7XG4gICAgICBncmlkLXRlbXBsYXRlLWNvbHVtbnM6IHJlcGVhdCg0LCBhdXRvKTtcbiAgICAgIG1hcmdpbi1ib3R0b206IDFyZW07XG4gICAgICBqdXN0aWZ5LWl0ZW1zOiBjZW50ZXI7XG4gICAgICBAbWVkaWEgKG1heC13aWR0aDogNDQwcHgpIHtcbiAgICAgICAgZGlzcGxheTogbm9uZTtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogMDtcbiAgICAgIH1cblxuICAgICAgc2VsZWN0IHtcbiAgICAgICAgbWFyZ2luOiAwO1xuICAgICAgICB3aWR0aDogNnJlbTtcbiAgICAgICAgaGVpZ2h0OiAxLjNyZW07XG4gICAgICAgIHBhZGRpbmc6IDA7XG4gICAgICAgIGZvbnQtc2l6ZTogMXJlbTtcbiAgICAgIH1cblxuICAgICAgLnJlc3VsdC1hbW91bnQge1xuICAgICAgfVxuXG4gICAgICAucG9zdC1idXR0b24ge1xuICAgICAgfVxuXG4gICAgICAucGFnaW5hdGlvbi1zbSB7XG4gICAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICB9XG4gICAgfVxuICB9XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/project/project-list/project-list.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectListComponent", function() { return ProjectListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ProjectListComponent = /** @class */ (function () {
    function ProjectListComponent(projectService, auth, router) {
        this.projectService = projectService;
        this.auth = auth;
        this.router = router;
    }
    ProjectListComponent.prototype.ngOnInit = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__["SortOrder"].DESC;
        this.page = 0;
        this.fetchAll(this.page, this.order);
        if (this.projectPage) {
            this.page = this.projectPage.number;
        }
    };
    /**
     * Returns a ProjectPage of all projects in the backend DB with no filtering
     * other than the required page & order.
     * @param page Page number. Starts at 0.
     * @param order Order of the projects. Must be a SortOrder enum.
     */
    ProjectListComponent.prototype.fetchAll = function (page, order) {
        var _this = this;
        this.projectService.fetchAll(page, order)
            .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.error(err.message); });
    };
    ProjectListComponent.prototype.nextPage = function () {
        this.fetchAll(++this.projectPage.number, this.order);
    };
    ProjectListComponent.prototype.previousPage = function () {
        this.fetchAll(--this.projectPage.number, this.order);
    };
    ProjectListComponent.prototype.filterByExample = function (page, example) {
        var _this = this;
        if (this.filteredQuery !== example && example != null) {
            this.filteredQuery = example;
        }
        this.projectService.searchProjects(page, this.order, this.orderBy, example)
            .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.error(err.message); });
    };
    ProjectListComponent.prototype.postForm = function () {
        this.router.navigate(['projects', 'post'])
            .catch(function (err) { return (console.error(err.message)); });
    };
    ProjectListComponent.prototype.sortByOldest = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__["SortOrder"].ASC;
        this.fetchAll(0, this.order);
    };
    ProjectListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-list',
            template: __webpack_require__(/*! ./project-list.component.html */ "./src/app/project/project-list/project-list.component.html"),
            styles: [__webpack_require__(/*! ./project-list.component.scss */ "./src/app/project/project-list/project-list.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["trigger"])('listStagger', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["transition"])('* <=> *', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["query"])(':enter', [
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({ opacity: 0, transform: 'translateY(-15px)' }),
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["stagger"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["animate"])('550ms ease-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({ opacity: 1, transform: 'translateY(0px)' })))
                        ], { optional: true }),
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"], _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]])
    ], ProjectListComponent);
    return ProjectListComponent;
}());



/***/ }),

/***/ "./src/app/project/project-post/project-post.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"'Post new project idea'\"></app-header>\n\n  <form (ngSubmit)=\"submit()\" #projectForm=\"ngForm\">\n    {{diagnostic}}\n      <div class=\"form-group\">\n        <label for=\"title\">Title</label>\n        <input type=\"text\" class=\"form-control\" id=\"title\"\n               required minlength=\"5\" maxlength=\"100\"\n               [(ngModel)]=\"model.title\" name=\"title\"\n               #title=\"ngModel\">\n        <div [hidden]=\"title.valid || title.pristine\"\n             class=\"alert alert-danger\">Title must be 5-30 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"difficulty\">Difficulty</label>\n        <select class=\"form-control\" id=\"difficulty\" required\n                [(ngModel)]=\"model.difficulty\" name=\"difficulty\">\n          <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n        </select>\n      </div>\n\n      <div class=\"form-group\">\n        <label for=\"description\">Description</label>\n        <textarea type=\"text\" class=\"form-control\" id=\"description\"\n                  required minlength=\"8\" maxlength=\"10000\"\n                  [(ngModel)]=\"model.description\" name=\"description\"\n                  #description=\"ngModel\" rows=\"3\"></textarea>\n        <div [hidden]=\"description.valid || description.pristine\"\n             class=\"alert alert-danger\">Description must be at least 8 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <button type=\"submit\" class=\"btn btn-primary clickable\"\n                [disabled]=\"!projectForm.form.valid\">submit</button>\n      </div>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-post/project-post.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "form {\n  max-width: 600px;\n  margin: auto; }\n  form .ng-valid[required], form .ng-valid.required {\n    border-left: 5px solid green; }\n  form .ng-invalid:not(form) {\n    border-left: 5px solid darkred; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL3Byb2plY3QvcHJvamVjdC1wb3N0L3Byb2plY3QtcG9zdC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGlCQUFnQjtFQUNoQixhQUFZLEVBU2I7RUFYRDtJQUtJLDZCQUE0QixFQUM3QjtFQU5IO0lBU0ksK0JBQThCLEVBQy9CIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LXBvc3QvcHJvamVjdC1wb3N0LmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiZm9ybSB7XG4gIG1heC13aWR0aDogNjAwcHg7XG4gIG1hcmdpbjogYXV0bztcblxuICAubmctdmFsaWRbcmVxdWlyZWRdLCAubmctdmFsaWQucmVxdWlyZWQge1xuICAgIGJvcmRlci1sZWZ0OiA1cHggc29saWQgZ3JlZW47XG4gIH1cblxuICAubmctaW52YWxpZDpub3QoZm9ybSkge1xuICAgIGJvcmRlci1sZWZ0OiA1cHggc29saWQgZGFya3JlZDtcbiAgfVxufVxuIl19 */"

/***/ }),

/***/ "./src/app/project/project-post/project-post.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectPostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectPostComponent", function() { return ProjectPostComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _project_search_project_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../project-search/project-creation */ "./src/app/project/project-search/project-creation.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ProjectPostComponent = /** @class */ (function () {
    function ProjectPostComponent(projectService, router, projectList) {
        this.projectService = projectService;
        this.router = router;
        this.projectList = projectList;
        this.difficulty = [
            'basic',
            'beginner',
            'intermediate',
            'advanced',
            'expert'
        ];
        this.model = new _project_search_project_creation__WEBPACK_IMPORTED_MODULE_1__["ProjectCreation"]('', '', '');
        this.submitted = false;
    }
    ProjectPostComponent.prototype.submit = function () {
        var _this = this;
        this.projectService.post(this.model)
            .subscribe(function (status) { return console.log(status); }, function (err) { return console.error(err.message); }, function () { return _this.submitted = true; })
            .add(function () { return _this.router.navigate(['projects']).then(function () { return _this.projectList.ngOnInit; }); });
    };
    Object.defineProperty(ProjectPostComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.model);
        },
        enumerable: true,
        configurable: true
    });
    ProjectPostComponent.prototype.ngOnDestroy = function () {
        this.submitted = false;
    };
    ProjectPostComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-post',
            template: __webpack_require__(/*! ./project-post.component.html */ "./src/app/project/project-post/project-post.component.html"),
            styles: [__webpack_require__(/*! ./project-post.component.scss */ "./src/app/project/project-post/project-post.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"],
            _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_4__["ProjectListComponent"]])
    ], ProjectPostComponent);
    return ProjectPostComponent;
}());



/***/ }),

/***/ "./src/app/project/project-search/project-creation.ts":
/*!************************************************************!*\
  !*** ./src/app/project/project-search/project-creation.ts ***!
  \************************************************************/
/*! exports provided: ProjectCreation */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectCreation", function() { return ProjectCreation; });
/**
 * A class for a project without ID and User fields.
 *
 * Suitable as a project post-form as well as a model for filtering via REST calls.
 */
var ProjectCreation = /** @class */ (function () {
    function ProjectCreation(title, difficulty, description) {
        this.title = title;
        this.difficulty = difficulty;
        this.description = description;
    }
    return ProjectCreation;
}());



/***/ }),

/***/ "./src/app/project/project-search/project-search.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container translucent-form-overlay\">\n  <form class=\"form-horizontal\" (ngSubmit)=\"filterProjects()\" #searchForm=\"ngForm\">\n    <h5>Filter Projects</h5>\n    <div class=\"form-group\">\n      <label for=\"title\" class=\"col-form-label\">Title</label>\n      <input type=\"text\" class=\"form-control input-elevated\" placeholder=\"Title contains...\" id=\"title\"\n             [(ngModel)]=\"searchedQuery.title\" name=\"title\">\n    </div>\n    <div class=\"form-group\">\n      <label for=\"difficulty\" class=\"col-form-label\">Difficulty</label>\n      <select class=\"form-control\" name=\"difficulty\" id=\"difficulty\"\n              [(ngModel)]=\"searchedQuery.difficulty\">\n        <option value='' selected>All</option>\n        <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n      </select>\n    </div>\n    <div class=\"form-group\">\n      <label for=\"description\" class=\"col-form-label\">Description</label>\n      <textarea type=\"text\" class=\"form-control input-elevated\" placeholder=\"Description\" id=\"description\"\n                [(ngModel)]=\"searchedQuery.description\" name=\"description\" rows=\"3\"></textarea>\n    </div>\n    <button type=\"submit\" class=\"btn btn-primary clickable\">\n      Filter\n    </button>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-search/project-search.component.scss":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.scss ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n.translucent-form-overlay {\n  max-width: 300px;\n  position: relative;\n  margin-right: 5rem; }\n@media screen and (max-width: 850px) {\n    .translucent-form-overlay {\n      display: none; } }\n.translucent-form-overlay h4, .translucent-form-overlay label {\n    color: #1c2331; }\n.translucent-form-overlay input, .translucent-form-overlay select {\n    color: gray;\n    background-color: white;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08); }\n.translucent-form-overlay select {\n    background-position: right; }\n.translucent-form-overlay input::-webkit-input-placeholder {\n    color: gray; }\n.translucent-form-overlay input::-ms-input-placeholder {\n    color: gray; }\n.translucent-form-overlay input::placeholder {\n    color: gray; }\n.translucent-form-overlay .input-elevated {\n    line-height: 1.5;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08);\n    border-radius: 5px; }\nlabel {\n  font-size: 1rem !important; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvcHJvamVjdC9wcm9qZWN0LXNlYXJjaC9wcm9qZWN0LXNlYXJjaC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSw0RUFBWTtBQ0NaO0VBQ0UsaUJBQWdCO0VBQ2hCLG1CQUFrQjtFQUNsQixtQkFBa0IsRUE0Qm5CO0FBMUJDO0lBTEY7TUFNSSxjQUFhLEVBeUJoQixFQUFBO0FBL0JEO0lBVUksZURUa0IsRUNVbkI7QUFYSDtJQWFJLFlBQVc7SUFDWCx3QkFBdUI7SUFDdkIsNENBQTJDLEVBQzVDO0FBaEJIO0lBbUJJLDJCQUEwQixFQUMzQjtBQXBCSDtJQXVCSSxZQUFXLEVBQ1o7QUF4Qkg7SUF1QkksWUFBVyxFQUNaO0FBeEJIO0lBdUJJLFlBQVcsRUFDWjtBQXhCSDtJQTJCSSxpQkFBZ0I7SUFDaEIsNENBQTJDO0lBQzNDLG1CQUFrQixFQUNuQjtBQUdIO0VBQ0UsMkJBQTBCLEVBQzNCIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LXNlYXJjaC9wcm9qZWN0LXNlYXJjaC5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi8vJGRhcms6IHJnYigyNSwgMjMsIDIyKTtcbkBpbXBvcnQgdXJsKCdodHRwczovL2ZvbnRzLmdvb2dsZWFwaXMuY29tL2Nzcz9mYW1pbHk9TW9udHNlcnJhdHxPcGVuK1NhbnMnKTtcblxuJGRhcms6IHJnYigyOCwgMzUsIDQ5KTtcbiRiYWNrZ3JvdW5kLWxpZ2h0OiByZ2JhKDI1NSwgMjUxLCAyNTQsIDEpO1xuJGJsdWU6IHJnYig2MiwgODAsIDkxKTtcbiRwcmltYXJ5OiAkYmx1ZTtcbiRwcmltYXJ5LWhvdmVyOiByZ2JhKDk5LCAxNTksIDE3MSwgMSk7XG4kbGlnaHQtZ3JheS1saW5lLWJvcmRlcjogI2U2ZTZlNiAycHggc29saWQ7XG4kYmctZ3JheTogI2U2ZTZlNjtcbiRmb250LWZhbWlseS1wcmltYXJ5OiAnTW9udHNlcnJhdCcsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktc2Vjb25kYXJ5OiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LXNpemUtYmFzZTogMXJlbTtcbiRmb250LWZhbWlseS1iYXNlOiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcbiRmb250LWZhbWlseS1jb2RlOiAnU291cmNlIENvZGUgUHJvJywgbW9ub3NwYWNlO1xuXG4kY29sb3JzOiAoXG4gIHByaW1hcnk6ICRwcmltYXJ5LFxuICBob3ZlcjogJHByaW1hcnktaG92ZXIsXG4gIGRhcms6ICRkYXJrLFxuICBiZy1saWdodDogJGJhY2tncm91bmQtbGlnaHQsXG4gIHByaW1hcnktaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBiZy1ncmF5OiAkYmctZ3JheVxuKTtcblxuQGZ1bmN0aW9uIGNvbG9yKCRjb2xvcikge1xuICBAcmV0dXJuIG1hcC1nZXQoJGNvbG9ycywgJGNvbG9yKVxufVxuXG4kdGhlbWUtY29sb3JzOiAoXG4gIFwicHJpbWFyeVwiOiAkcHJpbWFyeSxcbiAgXCJwcmltYXJ5LWhvdmVyXCI6ICRwcmltYXJ5LWhvdmVyXG4pO1xuXG5cbi5jb250YWluZXItZmx1aWQge1xuXG59XG4iLCJAaW1wb3J0IFwifnNyYy92YXJpYWJsZXNcIjtcblxuLnRyYW5zbHVjZW50LWZvcm0tb3ZlcmxheSB7XG4gIG1heC13aWR0aDogMzAwcHg7XG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcbiAgbWFyZ2luLXJpZ2h0OiA1cmVtO1xuXG4gIEBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6IDg1MHB4KSB7XG4gICAgZGlzcGxheTogbm9uZTtcbiAgfVxuXG4gIGg0LCBsYWJlbCB7XG4gICAgY29sb3I6ICRkYXJrO1xuICB9XG4gIGlucHV0LCBzZWxlY3Qge1xuICAgIGNvbG9yOiBncmF5O1xuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xuICAgIGJveC1zaGFkb3c6IDAgMnB4IDRweCAwIHJnYmEoMCwgMCwgMCwgMC4wOCk7XG4gIH1cblxuICBzZWxlY3Qge1xuICAgIGJhY2tncm91bmQtcG9zaXRpb246IHJpZ2h0O1xuICB9XG5cbiAgaW5wdXQ6OnBsYWNlaG9sZGVyIHtcbiAgICBjb2xvcjogZ3JheTtcbiAgfVxuXG4gIC5pbnB1dC1lbGV2YXRlZCB7XG4gICAgbGluZS1oZWlnaHQ6IDEuNTtcbiAgICBib3gtc2hhZG93OiAwIDJweCA0cHggMCByZ2JhKDAsIDAsIDAsIDAuMDgpO1xuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcbiAgfVxufVxuXG5sYWJlbCB7XG4gIGZvbnQtc2l6ZTogMXJlbSAhaW1wb3J0YW50O1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/project/project-search/project-search.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.ts ***!
  \********************************************************************/
/*! exports provided: ProjectSearchComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectSearchComponent", function() { return ProjectSearchComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _project_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./project-creation */ "./src/app/project/project-search/project-creation.ts");
/* harmony import */ var _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ProjectSearchComponent = /** @class */ (function () {
    function ProjectSearchComponent(list) {
        this.list = list;
        this.difficulty = [
            'basic',
            'beginner',
            'intermediate',
            'advanced',
            'expert'
        ];
        this.searchedQuery = new _project_creation__WEBPACK_IMPORTED_MODULE_1__["ProjectCreation"]('', '', '');
    }
    ProjectSearchComponent.prototype.filterProjects = function () {
        this.list.filterByExample(0, this.searchedQuery);
    };
    ProjectSearchComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-search',
            template: __webpack_require__(/*! ./project-search.component.html */ "./src/app/project/project-search/project-search.component.html"),
            styles: [__webpack_require__(/*! ./project-search.component.scss */ "./src/app/project/project-search/project-search.component.scss")]
        }),
        __metadata("design:paramtypes", [_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__["ProjectListComponent"]])
    ], ProjectSearchComponent);
    return ProjectSearchComponent;
}());



/***/ }),

/***/ "./src/app/shared/auth.service.ts":
/*!****************************************!*\
  !*** ./src/app/shared/auth.service.ts ***!
  \****************************************/
/*! exports provided: AuthService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthService", function() { return AuthService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AuthService = /** @class */ (function () {
    function AuthService(http) {
        this.http = http;
        this.authenticated = false;
    }
    AuthService.prototype.authenticate = function () {
        var _this = this;
        if (!this.authenticated) {
            this.http.get('/api/auth/user').subscribe(function (data) {
                _this.authenticated = JSON.stringify(data).includes('login');
                if (_this.authenticated) {
                    _this.currentUser = data;
                }
            }, function (err) { return console.error(err.message); });
        }
    };
    AuthService.prototype.logout = function () {
        this.currentUser = null;
        this.authenticated = false;
        return this.http.post('/api/auth/logout', {});
    };
    AuthService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/shared/difficulty.ts":
/*!**************************************!*\
  !*** ./src/app/shared/difficulty.ts ***!
  \**************************************/
/*! exports provided: Difficulty */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Difficulty", function() { return Difficulty; });
var Difficulty;
(function (Difficulty) {
    Difficulty["BASIC"] = "basic";
    Difficulty["BEGINNER"] = "beginner";
    Difficulty["INTERMEDIATE"] = "intermediate";
    Difficulty["ADVANCED"] = "advanced";
    Difficulty["EXPERT"] = "expert";
})(Difficulty || (Difficulty = {}));


/***/ }),

/***/ "./src/app/shared/pipes/ellipsis.pipe.ts":
/*!***********************************************!*\
  !*** ./src/app/shared/pipes/ellipsis.pipe.ts ***!
  \***********************************************/
/*! exports provided: EllipsisPipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EllipsisPipe", function() { return EllipsisPipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var EllipsisPipe = /** @class */ (function () {
    function EllipsisPipe() {
    }
    EllipsisPipe.prototype.transform = function (text, length) {
        if (text === undefined || text.length <= length) {
            return text;
        }
        return text.substr(0, length).concat("...");
    };
    EllipsisPipe = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Pipe"])({
            name: 'ellipsis'
        })
    ], EllipsisPipe);
    return EllipsisPipe;
}());



/***/ }),

/***/ "./src/app/shared/project.service.ts":
/*!*******************************************!*\
  !*** ./src/app/shared/project.service.ts ***!
  \*******************************************/
/*! exports provided: ProjectService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectService", function() { return ProjectService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _difficulty__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./difficulty */ "./src/app/shared/difficulty.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ProjectService = /** @class */ (function () {
    function ProjectService(http) {
        this.http = http;
        this.URL = '/api/projects';
    }
    /**
     * Returns a ProjectPage of all projects in the backend DB with no filtering other than the required page & order.
     * @param page Page number. Starts at 0.
     * @param sortOrder Order of the projects. Must either be 'desc' or 'asc'.
     */
    ProjectService.prototype.fetchAll = function (page, sortOrder) {
        return this.http.get(this.URL + "?page=" + page + "&sort=rating," + sortOrder);
    };
    ProjectService.prototype.fetchById = function (id) {
        return this.http.get(this.URL + "/" + id);
    };
    ProjectService.prototype.post = function (project) {
        return this.http.post(this.URL, project);
    };
    ProjectService.prototype.postComment = function (projectId, comment) {
        return this.http.post(this.URL + "/" + projectId + "/comments", comment, { observe: 'response' });
    };
    ProjectService.prototype.fetchProjectComments = function (projectId, sortOrder, pageNum) {
        return this.http.get(this.URL + "/" + projectId + "/comments?page=" + pageNum + "&sort=datePosted," + sortOrder);
    };
    ProjectService.prototype.deleteComment = function (projectId, commentId) {
        return this.http.delete(this.URL + "/" + projectId + "/comments/" + commentId);
    };
    ProjectService.prototype.deleteProject = function (projectId) {
        return this.http.delete(this.URL + "/" + projectId);
    };
    ProjectService.prototype.editComment = function (comment, projectId) {
        return this.http.put(this.URL + "/" + projectId + "/comments/" + comment.id, comment);
    };
    ProjectService.prototype.updateProject = function (project) {
        return this.http.put(this.URL + "/" + project.id, project);
    };
    ProjectService.prototype.voteOnProject = function (vote, projectId) {
        this.http.post(this.URL + "/" + projectId + "/vote?dir=" + vote, {}).subscribe(function () { });
    };
    // TODO remove the hardcoded sort
    ProjectService.prototype.searchProjects = function (page, sortOrder, sort, values) {
        return this.http.get(this.URL
            + ("?title=" + values.title)
            + ("&difficulty=" + values.difficulty)
            + ("&description=" + values.description)
            + ("&page=" + page)
            + ("&sort=rating," + sortOrder) /*TODO: Fix me*/);
    };
    ProjectService.prototype.setColor = function (difficulty) {
        switch (difficulty) {
            case _difficulty__WEBPACK_IMPORTED_MODULE_2__["Difficulty"].BASIC: {
                return "#858585";
            }
            case _difficulty__WEBPACK_IMPORTED_MODULE_2__["Difficulty"].BEGINNER: {
                return "#2b803e";
            }
            case _difficulty__WEBPACK_IMPORTED_MODULE_2__["Difficulty"].INTERMEDIATE: {
                return "#2a628e";
            }
            case _difficulty__WEBPACK_IMPORTED_MODULE_2__["Difficulty"].ADVANCED: {
                return "#aa7308";
            }
            case _difficulty__WEBPACK_IMPORTED_MODULE_2__["Difficulty"].EXPERT: {
                return "#aa1828";
            }
        }
    };
    ProjectService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], ProjectService);
    return ProjectService;
}());



/***/ }),

/***/ "./src/app/shared/sort-order.ts":
/*!**************************************!*\
  !*** ./src/app/shared/sort-order.ts ***!
  \**************************************/
/*! exports provided: SortOrder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SortOrder", function() { return SortOrder; });
var SortOrder;
(function (SortOrder) {
    SortOrder["ASC"] = "asc";
    SortOrder["DESC"] = "desc";
})(SortOrder || (SortOrder = {}));


/***/ }),

/***/ "./src/app/shared/user.service.ts":
/*!****************************************!*\
  !*** ./src/app/shared/user.service.ts ***!
  \****************************************/
/*! exports provided: UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return UserService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var UserService = /** @class */ (function () {
    function UserService(http) {
        this.http = http;
        this.URL = '/api/users';
    }
    UserService.prototype.fetchById = function (id) {
        return this.http.get(this.URL + "/" + id);
    };
    UserService.prototype.fetchAll = function (page, sortOrder) {
        return this.http.get(this.URL + "?page=" + page + "&sort=" + sortOrder);
    };
    UserService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], UserService);
    return UserService;
}());



/***/ }),

/***/ "./src/app/shared/vote.enum.ts":
/*!*************************************!*\
  !*** ./src/app/shared/vote.enum.ts ***!
  \*************************************/
/*! exports provided: Vote */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Vote", function() { return Vote; });
var Vote;
(function (Vote) {
    Vote["UPVOTE"] = "UPVOTE";
    Vote["DOWNVOTE"] = "DOWNVOTE";
})(Vote || (Vote = {}));


/***/ }),

/***/ "./src/app/sidenav/sidenav.component.html":
/*!************************************************!*\
  !*** ./src/app/sidenav/sidenav.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"side-nav\" class=\"container-fluid p-0\">\n<ul class=\"nav flex-column\">\n  <li class=\"nav-item\">\n    <a class=\"nav-link active\" href=\"#\">Active</a>\n  </li>\n  <li class=\"nav-item\">\n    <a class=\"nav-link\" href=\"#\">Link</a>\n  </li>\n  <li class=\"nav-item\">\n    <a class=\"nav-link\" href=\"#\">Link</a>\n  </li>\n  <li class=\"nav-item\">\n    <a class=\"nav-link disabled\" href=\"#\">Disabled</a>\n  </li>\n</ul>\n</div>\n"

/***/ }),

/***/ "./src/app/sidenav/sidenav.component.scss":
/*!************************************************!*\
  !*** ./src/app/sidenav/sidenav.component.scss ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#side-nav.container-fluid.p-0 {\n  max-width: 10%;\n  border-right: #999999 1px solid; }\n  #side-nav.container-fluid.p-0 ul.nav.flex-column {\n    background-color: #fffbfe;\n    min-height: 100vh; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL3NpZGVuYXYvc2lkZW5hdi5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQWM7RUFDZCxnQ0FBK0IsRUFNaEM7RUFSRDtJQUtJLDBCQUF5QjtJQUN6QixrQkFBaUIsRUFDbEIiLCJmaWxlIjoic3JjL2FwcC9zaWRlbmF2L3NpZGVuYXYuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIjc2lkZS1uYXYuY29udGFpbmVyLWZsdWlkLnAtMCB7XG4gIG1heC13aWR0aDogMTAlO1xuICBib3JkZXItcmlnaHQ6ICM5OTk5OTkgMXB4IHNvbGlkO1xuXG4gIHVsLm5hdi5mbGV4LWNvbHVtbiB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2ZmZmJmZTtcbiAgICBtaW4taGVpZ2h0OiAxMDB2aDtcbiAgfVxufVxuIl19 */"

/***/ }),

/***/ "./src/app/sidenav/sidenav.component.ts":
/*!**********************************************!*\
  !*** ./src/app/sidenav/sidenav.component.ts ***!
  \**********************************************/
/*! exports provided: SidenavComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SidenavComponent", function() { return SidenavComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SidenavComponent = /** @class */ (function () {
    function SidenavComponent() {
    }
    SidenavComponent.prototype.ngOnInit = function () {
    };
    SidenavComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-sidenav',
            template: __webpack_require__(/*! ./sidenav.component.html */ "./src/app/sidenav/sidenav.component.html"),
            styles: [__webpack_require__(/*! ./sidenav.component.scss */ "./src/app/sidenav/sidenav.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], SidenavComponent);
    return SidenavComponent;
}());



/***/ }),

/***/ "./src/app/user/user-card/user-card.component.html":
/*!*********************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"user-card\">\n  <div id=\"user-info\">\n    <img class=\"avatar\" src=\"{{user?.avatar_url}}\">\n    <div class=\"metadata\">\n      <div class=\"login\">{{user?.login}}</div>\n      <div *ngIf=\"user?.hireable\" class=\"hireable\">Looking for work</div>\n      <div id=\"user-icon-links\">\n      <a class=\"github-url\" href=\"https://github.com/{{user?.login}}\">\n        <i class=\"fa fa-github fa-2x\"></i></a>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/user/user-card/user-card.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@import url(\"https://fonts.googleapis.com/css?family=Montserrat|Open+Sans\");\n#user-card {\n  max-width: -webkit-fit-content;\n  max-width: -moz-fit-content;\n  max-width: fit-content;\n  justify-self: center;\n  margin-bottom: 3rem; }\n#user-card #user-info {\n    display: grid;\n    grid-template-columns: -webkit-min-content auto;\n    grid-template-columns: min-content auto; }\n#user-card #user-info .avatar {\n      max-height: 75px;\n      max-width: 75px;\n      border-radius: 50px;\n      box-shadow: 0 3px .3rem black; }\n#user-card #user-info .metadata {\n      display: grid;\n      font-size: 1rem;\n      margin-left: 1rem;\n      grid-template-rows: repeat(3, -webkit-min-content);\n      grid-template-rows: repeat(3, min-content); }\n#user-card #user-info .metadata .login {\n        font-family: \"Montserrat\", sans-serif !important;\n        font-size: 1.2rem;\n        color: #1c2331; }\n#user-card #user-info .metadata .hireable {\n        font-family: \"Open Sans\", sans-serif;\n        font-size: .95rem;\n        color: gray; }\n#user-card #user-info .metadata #user-icon-links {\n        font-size: .7rem;\n        margin-top: .3rem; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvX3ZhcmlhYmxlcy5zY3NzIiwiL2hvbWUvU21va2V5L0Rlc2t0b3Avc3Vkb2NvZGUtb3JnL2Zyb250ZW5kL3NyYy9hcHAvdXNlci91c2VyLWNhcmQvdXNlci1jYXJkLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNBLDRFQUFZO0FDQ1o7RUFDQSwrQkFBc0I7RUFBdEIsNEJBQXNCO0VBQXRCLHVCQUFzQjtFQUN0QixxQkFBb0I7RUFDcEIsb0JBQW1CLEVBdUNsQjtBQTFDRDtJQU1JLGNBQWE7SUFDYixnREFBdUM7SUFBdkMsd0NBQXVDLEVBZ0N4QztBQXZDSDtNQVVNLGlCQUFnQjtNQUNoQixnQkFBZTtNQUNmLG9CQUFtQjtNQUNuQiw4QkFBNkIsRUFDOUI7QUFkTDtNQWlCTSxjQUFhO01BQ2IsZ0JBQWU7TUFDZixrQkFBaUI7TUFDakIsbURBQTBDO01BQTFDLDJDQUEwQyxFQWtCM0M7QUF0Q0w7UUF1QlEsaURBQTRDO1FBQzVDLGtCQUFpQjtRQUNqQixlRHhCYyxFQ3lCZjtBQTFCUDtRQTZCUSxxQ0RwQnVDO1FDcUJ2QyxrQkFBaUI7UUFDakIsWUFBVyxFQUNaO0FBaENQO1FBbUNRLGlCQUFnQjtRQUNoQixrQkFBaUIsRUFDbEIiLCJmaWxlIjoic3JjL2FwcC91c2VyL3VzZXItY2FyZC91c2VyLWNhcmQuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvLyRkYXJrOiByZ2IoMjUsIDIzLCAyMik7XG5AaW1wb3J0IHVybCgnaHR0cHM6Ly9mb250cy5nb29nbGVhcGlzLmNvbS9jc3M/ZmFtaWx5PU1vbnRzZXJyYXR8T3BlbitTYW5zJyk7XG5cbiRkYXJrOiByZ2IoMjgsIDM1LCA0OSk7XG4kYmFja2dyb3VuZC1saWdodDogcmdiYSgyNTUsIDI1MSwgMjU0LCAxKTtcbiRibHVlOiByZ2IoNjIsIDgwLCA5MSk7XG4kcHJpbWFyeTogJGJsdWU7XG4kcHJpbWFyeS1ob3ZlcjogcmdiYSg5OSwgMTU5LCAxNzEsIDEpO1xuJGxpZ2h0LWdyYXktbGluZS1ib3JkZXI6ICNlNmU2ZTYgMnB4IHNvbGlkO1xuJGJnLWdyYXk6ICNlNmU2ZTY7XG4kZm9udC1mYW1pbHktcHJpbWFyeTogJ01vbnRzZXJyYXQnLCBzYW5zLXNlcmlmO1xuJGZvbnQtZmFtaWx5LXNlY29uZGFyeTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1zaXplLWJhc2U6IDFyZW07XG4kZm9udC1mYW1pbHktYmFzZTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XG4kZm9udC1mYW1pbHktY29kZTogJ1NvdXJjZSBDb2RlIFBybycsIG1vbm9zcGFjZTtcblxuJGNvbG9yczogKFxuICBwcmltYXJ5OiAkcHJpbWFyeSxcbiAgaG92ZXI6ICRwcmltYXJ5LWhvdmVyLFxuICBkYXJrOiAkZGFyayxcbiAgYmctbGlnaHQ6ICRiYWNrZ3JvdW5kLWxpZ2h0LFxuICBwcmltYXJ5LWhvdmVyOiAkcHJpbWFyeS1ob3ZlcixcbiAgYmctZ3JheTogJGJnLWdyYXlcbik7XG5cbkBmdW5jdGlvbiBjb2xvcigkY29sb3IpIHtcbiAgQHJldHVybiBtYXAtZ2V0KCRjb2xvcnMsICRjb2xvcilcbn1cblxuJHRoZW1lLWNvbG9yczogKFxuICBcInByaW1hcnlcIjogJHByaW1hcnksXG4gIFwicHJpbWFyeS1ob3ZlclwiOiAkcHJpbWFyeS1ob3ZlclxuKTtcblxuXG4uY29udGFpbmVyLWZsdWlkIHtcblxufVxuIiwiQGltcG9ydCBcIn5zcmMvX3ZhcmlhYmxlcy5zY3NzXCI7XG5cbiN1c2VyLWNhcmQge1xubWF4LXdpZHRoOiBmaXQtY29udGVudDtcbmp1c3RpZnktc2VsZjogY2VudGVyO1xubWFyZ2luLWJvdHRvbTogM3JlbTtcblxuICAjdXNlci1pbmZvIHtcbiAgICBkaXNwbGF5OiBncmlkO1xuICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogbWluLWNvbnRlbnQgYXV0bztcblxuICAgIC5hdmF0YXIge1xuICAgICAgbWF4LWhlaWdodDogNzVweDtcbiAgICAgIG1heC13aWR0aDogNzVweDtcbiAgICAgIGJvcmRlci1yYWRpdXM6IDUwcHg7XG4gICAgICBib3gtc2hhZG93OiAwIDNweCAuM3JlbSBibGFjaztcbiAgICB9XG5cbiAgICAubWV0YWRhdGEge1xuICAgICAgZGlzcGxheTogZ3JpZDtcbiAgICAgIGZvbnQtc2l6ZTogMXJlbTtcbiAgICAgIG1hcmdpbi1sZWZ0OiAxcmVtO1xuICAgICAgZ3JpZC10ZW1wbGF0ZS1yb3dzOiByZXBlYXQoMywgbWluLWNvbnRlbnQpO1xuXG4gICAgICAubG9naW4ge1xuICAgICAgICBmb250LWZhbWlseTogJGZvbnQtZmFtaWx5LXByaW1hcnkgIWltcG9ydGFudDtcbiAgICAgICAgZm9udC1zaXplOiAxLjJyZW07XG4gICAgICAgIGNvbG9yOiAkZGFyaztcbiAgICAgIH1cblxuICAgICAgLmhpcmVhYmxlIHtcbiAgICAgICAgZm9udC1mYW1pbHk6ICRmb250LWZhbWlseS1zZWNvbmRhcnk7XG4gICAgICAgIGZvbnQtc2l6ZTogLjk1cmVtO1xuICAgICAgICBjb2xvcjogZ3JheTtcbiAgICAgIH1cblxuICAgICAgI3VzZXItaWNvbi1saW5rcyB7XG4gICAgICAgIGZvbnQtc2l6ZTogLjdyZW07XG4gICAgICAgIG1hcmdpbi10b3A6IC4zcmVtO1xuICAgICAgfVxuICAgIH1cbiAgfVxuXG5cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/user/user-card/user-card.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.ts ***!
  \*******************************************************/
/*! exports provided: UserCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserCardComponent", function() { return UserCardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var UserCardComponent = /** @class */ (function () {
    function UserCardComponent() {
    }
    UserCardComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], UserCardComponent.prototype, "user", void 0);
    UserCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-user-card',
            template: __webpack_require__(/*! ./user-card.component.html */ "./src/app/user/user-card/user-card.component.html"),
            styles: [__webpack_require__(/*! ./user-card.component.scss */ "./src/app/user/user-card/user-card.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], UserCardComponent);
    return UserCardComponent;
}());



/***/ }),

/***/ "./src/app/user/user-list/user-list.component.html":
/*!*********************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\" >\n  <app-header [headerText]=\"'Users'\"></app-header>\n  <ul class=\"user-list\" *ngIf=\"users\">\n    <li *ngFor=\"let user of users?.content\">\n      <app-user-card [user]=\"user\"></app-user-card>\n    </li>\n  </ul>\n</div>\n"

/***/ }),

/***/ "./src/app/user/user-list/user-list.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".user-list li {\n  display: grid;\n  grid-template-columns: repeat(4, auto); }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9ob21lL1Ntb2tleS9EZXNrdG9wL3N1ZG9jb2RlLW9yZy9mcm9udGVuZC9zcmMvYXBwL3VzZXIvdXNlci1saXN0L3VzZXItbGlzdC5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGNBQWE7RUFDYix1Q0FBc0MsRUFDdkMiLCJmaWxlIjoic3JjL2FwcC91c2VyL3VzZXItbGlzdC91c2VyLWxpc3QuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudXNlci1saXN0IGxpIHtcbiAgZGlzcGxheTogZ3JpZDtcbiAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiByZXBlYXQoNCwgYXV0byk7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/user/user-list/user-list.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.ts ***!
  \*******************************************************/
/*! exports provided: UserListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserListComponent", function() { return UserListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/user.service */ "./src/app/shared/user.service.ts");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UserListComponent = /** @class */ (function () {
    function UserListComponent(userService) {
        this.userService = userService;
    }
    UserListComponent.prototype.ngOnInit = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_2__["SortOrder"].DESC;
        this.pageNum = 0;
        this.fetchAll(this.pageNum, this.order);
        if (this.users) {
            this.pageNum = this.users.number;
        }
    };
    UserListComponent.prototype.fetchAll = function (page, order) {
        var _this = this;
        this.userService.fetchAll(page, order)
            .subscribe(function (data) { return _this.users = data; }, function (err) { return console.error(err.message); });
    };
    UserListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-user-list',
            template: __webpack_require__(/*! ./user-list.component.html */ "./src/app/user/user-list/user-list.component.html"),
            styles: [__webpack_require__(/*! ./user-list.component.scss */ "./src/app/user/user-list/user-list.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_user_service__WEBPACK_IMPORTED_MODULE_1__["UserService"]])
    ], UserListComponent);
    return UserListComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, for easier debugging, you can ignore zone related error
 * stack frames such as `zone.run`/`zoneDelegate.invokeTask` by importing the
 * below file. Don't forget to comment it out in production mode
 * because it will have a performance impact when errors are thrown
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/Smokey/Desktop/sudocode-org/frontend/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map