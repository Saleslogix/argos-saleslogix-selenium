$ROOT = $PSScriptRoot

Write-Host $ROOT

& java `
    "-Dwebdriver.chrome.driver=$ROOT\drivers\WIN\chromedriver.exe" `
     -jar $ROOT\selenium-server-standalone-3.3.1.jar -role standalone