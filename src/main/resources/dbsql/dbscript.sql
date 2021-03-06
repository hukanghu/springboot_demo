USE [master]
GO
/****** Object:  Database [PersonDB]    Script Date: 03/19/2020 09:29:11 ******/
CREATE DATABASE [PersonDB] ON  PRIMARY 
( NAME = N'PersonDB', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\PersonDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PersonDB_log', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\PersonDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PersonDB] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PersonDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PersonDB] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PersonDB] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PersonDB] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PersonDB] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PersonDB] SET ARITHABORT OFF
GO
ALTER DATABASE [PersonDB] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [PersonDB] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PersonDB] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PersonDB] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PersonDB] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PersonDB] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PersonDB] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PersonDB] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PersonDB] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PersonDB] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PersonDB] SET  DISABLE_BROKER
GO
ALTER DATABASE [PersonDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PersonDB] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PersonDB] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PersonDB] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PersonDB] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PersonDB] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PersonDB] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PersonDB] SET  READ_WRITE
GO
ALTER DATABASE [PersonDB] SET RECOVERY FULL
GO
ALTER DATABASE [PersonDB] SET  MULTI_USER
GO
ALTER DATABASE [PersonDB] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PersonDB] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'PersonDB', N'ON'
GO
USE [PersonDB]
GO
/****** Object:  Table [dbo].[TIME_VALUE]    Script Date: 03/19/2020 09:29:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIME_VALUE](
	[PID] [int] IDENTITY(1,1) NOT NULL,
	[YearValue] [varchar](50) NULL,
	[MonthValue] [varchar](50) NULL,
	[DayValue] [varchar](50) NULL,
	[HourValue] [varchar](50) NULL,
	[MIValue] [varchar](50) NULL,
	[SSValue] [varchar](50) NULL,
	[WeekValue] [varchar](50) NULL,
	[QVALUE] [varchar](50) NULL,
	[WWVALUE] [varchar](50) NULL,
	[DVALUE] [varchar](50) NULL,
	[DDDVALUE] [varchar](50) NULL,
	[time_value] [datetime] NULL,
	[sql] [varchar](max) NULL,
 CONSTRAINT [PK_TIME_VALUE] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
CREATE NONCLUSTERED INDEX [time_date] ON [dbo].[TIME_VALUE] 
(
	[YearValue] ASC,
	[MonthValue] ASC,
	[DayValue] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TIME_DAY]    Script Date: 03/19/2020 09:29:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIME_DAY](
	[PID] [int] IDENTITY(1,1) NOT NULL,
	[YearValue] [varchar](50) NULL,
	[MonthValue] [varchar](50) NULL,
	[DayValue] [varchar](50) NULL,
 CONSTRAINT [PK_TIME_DAY] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[STUDENT_CLASS]    Script Date: 03/19/2020 09:29:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[STUDENT_CLASS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](200) NULL,
	[CLASSNAME] [varchar](50) NULL,
 CONSTRAINT [PK_STUDENT_CLASS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  UserDefinedFunction [dbo].[SplitSubString]    Script Date: 03/19/2020 09:29:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE function [dbo].[SplitSubString]
(
 @Expression varchar(8000)
,@Delimiter varchar(100)
,@ int
)
returns varchar(8000)
as
begin


declare @p int,
        @temp varchar(8000)
set @p = CharIndex(@Delimiter,@Expression)
set @temp = @Expression
if @p > 0
begin
   set @p = @p + len(@Delimiter) - 1
end
declare @i int
set @i = 1
while @i < @
begin  
   set @i = @i + 1
   set @Expression = substring (@Expression, @p + 1,len(@Expression) - @p )
   set @p = CharIndex(@Delimiter,@Expression)
   if @p > 0
       begin
          set @p = @p + len(@Delimiter) - 1
       end
   else
       begin
          break
       end
end

declare @s varchar(1000)
if @p = 0 and @i = @
begin
    if @ > 1
    begin
        if len(@Expression) < len(@temp)
        begin
            set @s=@Expression
        end
        else
            begin
                set @s = null
            end
    end
    else
        begin
            set @s=@Expression
        end
end
else if @i = @
begin
   set @s = substring(@Expression, 1,@p - len(@Delimiter))
end
return @s
end
GO
/****** Object:  Table [dbo].[emp]    Script Date: 03/19/2020 09:29:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[emp](
	[PID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[desc] [nvarchar](50) NULL,
	[passworld] [varchar](50) NULL,
	[createdate] [datetime] NULL,
 CONSTRAINT [PK_emp] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Class_Course]    Script Date: 03/19/2020 09:29:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class_Course](
	[name] [varchar](50) NULL,
	[pid] [int] NOT NULL,
	[course] [varchar](50) NULL,
	[score] [int] NULL,
 CONSTRAINT [PK_Class_Course] PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
