function getBrowserLang(){
	let userLangFullName = navigator.language || navigator.userLanguage;
	let userlang = userLangFullName.split('-')[0];
	return userlang;
}