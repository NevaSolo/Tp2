$ErrorActionPreference = 'Stop'
$chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+'
$pwdPlain = -join ((1..16) | ForEach-Object { $chars[(Get-Random -Maximum $chars.Length)] })
$secure = ConvertTo-SecureString $pwdPlain -AsPlainText -Force
if (-not (Get-LocalUser -Name 'jenkins' -ErrorAction SilentlyContinue)) {
    New-LocalUser -Name 'jenkins' -Password $secure -FullName 'Jenkins Service' -Description 'Compte service pour Jenkins'
    Add-LocalGroupMember -Group 'Users' -Member 'jenkins'
    Write-Output "User jenkins created"
} else {
    Set-LocalUser -Name 'jenkins' -Password $secure
    Write-Output "User jenkins already existed; password updated"
}
$path='C:\Program Files\Jenkins'
if (-not (Test-Path $path)) {
    New-Item -ItemType Directory -Path $path -Force | Out-Null
    Write-Output "Created folder $path"
}
$rule = New-Object System.Security.AccessControl.FileSystemAccessRule('jenkins','Modify','ContainerInherit,ObjectInherit','None','Allow')
$acl = Get-Acl $path
$acl.AddAccessRule($rule)
Set-Acl -Path $path -AclObject $acl
Write-Output "Assigned Modify permissions on $path to jenkins"
Write-Output "Generated password (store it securely): $pwdPlain"
Write-Output "Next: add 'Log on as a service' for user 'jenkins' via secpol.msc -> Local Policies -> User Rights Assignment -> Log on as a service"
