USE [master]
GO
/****** Object:  Database [Main]    Script Date: 5/18/2019 3:19:13 PM ******/
CREATE DATABASE [Main]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Main_Fahims', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Main_fahims2.mdf' , SIZE = 113664KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Main_Fahims_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Main_fahims2_log.LDF' , SIZE = 47616KB , MAXSIZE = UNLIMITED, FILEGROWTH = 10%)
GO
ALTER DATABASE [Main] SET COMPATIBILITY_LEVEL = 90
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Main].[dbo].[sp_fulltext_database] @action = 'disable'
end
GO
ALTER DATABASE [Main] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Main] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Main] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Main] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Main] SET ARITHABORT OFF 
GO
ALTER DATABASE [Main] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Main] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Main] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Main] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Main] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Main] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Main] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Main] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Main] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Main] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Main] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Main] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Main] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Main] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Main] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Main] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Main] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Main] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Main] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Main] SET  MULTI_USER 
GO
ALTER DATABASE [Main] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Main] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Main] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Main] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Main', N'ON'
GO
USE [Main]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Id_Account] [int] IDENTITY(1,1) NOT NULL,
	[Id_AccountSubGroup] [int] NULL,
	[Code] [nvarchar](5) NULL,
	[Name] [nvarchar](50) NULL,
	[Remarks] [nvarchar](200) NULL,
	[IsLocked] [bit] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Id_Account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AccountGroup]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccountGroup](
	[Id_AccountGroup] [int] IDENTITY(1,1) NOT NULL,
	[Id_AccountType] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[Code] [nvarchar](2) NULL,
	[Remarks] [nvarchar](200) NULL,
	[IsLocked] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_AccountGroup] PRIMARY KEY CLUSTERED 
(
	[Id_AccountGroup] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AccountSubGroup]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccountSubGroup](
	[Id_AccountSubGroup] [int] IDENTITY(1,1) NOT NULL,
	[Id_AccountGroup] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[Code] [nvarchar](3) NULL,
	[Remarks] [nvarchar](200) NULL,
	[IsLocked] [bit] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AccountType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccountType](
	[Id_AccountType] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[OrderNo] [int] NULL,
	[Color] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Code] [nvarchar](2) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Area]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Area](
	[ID_Area] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
 CONSTRAINT [PK_Area_1] PRIMARY KEY CLUSTERED 
(
	[ID_Area] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AttendanceStatus]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AttendanceStatus](
	[Id_AttendanceStatus] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bank]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bank](
	[Id_Bank] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Book]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[ID_Book] [int] IDENTITY(1,1) NOT NULL,
	[ID_BookLanguage] [int] NULL,
	[ID_BookSubGroup] [int] NULL,
	[ID_BookPublisher] [int] NULL,
	[ID_BookType] [int] NULL,
	[Author] [nvarchar](255) NULL,
	[Title] [nvarchar](255) NULL,
	[Description] [nvarchar](255) NULL,
	[ISBN] [nvarchar](255) NULL,
	[Pages] [int] NULL,
	[AgeLimit] [int] NULL,
	[ID_User] [smallint] NULL,
	[UserTime] [datetime] NULL,
	[Stars] [int] NULL,
 CONSTRAINT [aaaaaBook_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_Book] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookCondition]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookCondition](
	[ID_BookCondition] [int] NOT NULL,
	[Name] [nvarchar](255) NULL,
	[IconNo] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookCopy]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookCopy](
	[ID_BookCopy] [int] IDENTITY(1,1) NOT NULL,
	[ID_Book] [int] NULL,
	[ID_BookCondition] [smallint] NULL,
	[CopyNo] [int] NULL,
	[StockInDate] [datetime] NULL,
	[Cost] [int] NULL,
	[Remarks] [nvarchar](255) NULL,
	[StockOutDate] [datetime] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[ID_BookShelf] [int] NULL,
 CONSTRAINT [aaaaaBookCopy_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_BookCopy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookGroup]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookGroup](
	[ID_BookGroup] [int] NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookLanguage]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookLanguage](
	[ID_BookLanguage] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaBookLanguage_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_BookLanguage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookPublisher]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookPublisher](
	[ID_BookPublisher] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaBookPublisher_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_BookPublisher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookShelf]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookShelf](
	[ID_BookShelf] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaBookShelf_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_BookShelf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookSubGroup]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookSubGroup](
	[ID_BookSubGroup] [int] NOT NULL,
	[ID_BookGroup] [int] NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookTransaction]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookTransaction](
	[ID_BookTransaction] [int] IDENTITY(1,1) NOT NULL,
	[ID_BookCopy] [int] NULL,
	[ID_LibraryCard] [int] NULL,
	[IssueDate] [datetime] NULL,
	[ID_IssuedCondition] [int] NULL,
	[ForDays] [int] NULL,
	[IsReturned] [bit] NOT NULL,
	[ReturnDate] [datetime] NULL,
	[ID_ReturnedCondition] [int] NULL,
	[LateFine] [money] NULL,
	[FineIsPaid] [bit] NOT NULL,
	[Remarks] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsRated] [bit] NOT NULL,
	[Stars] [int] NULL,
 CONSTRAINT [aaaaaBookTransaction_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_BookTransaction] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookType](
	[ID_BookType] [int] NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IconNo] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Calendar]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Calendar](
	[Id_Calendar] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[ID_Category] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[OrderNo] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[BankAccount] [varchar](255) NULL,
	[Short] [varchar](5) NULL,
	[code] [int] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[ID_Category] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ChequeType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChequeType](
	[Id_ChequeType] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Short] [nvarchar](50) NULL,
	[OrderNo] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Class]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class](
	[ID_Class] [int] IDENTITY(1,1) NOT NULL,
	[ID_Category] [int] NULL,
	[Name] [varchar](50) NULL,
	[IsDeleted] [bit] NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
	[Level] [int] NULL,
 CONSTRAINT [PK_Class_1] PRIMARY KEY CLUSTERED 
(
	[ID_Class] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ClassDocument]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClassDocument](
	[Id_ClassDocument] [int] IDENTITY(1,1) NOT NULL,
	[Id_Class] [int] NULL,
	[Id_Document] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_ClassDocument] PRIMARY KEY CLUSTERED 
(
	[Id_ClassDocument] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ClassFee]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClassFee](
	[Id_ClassFee] [int] IDENTITY(1,1) NOT NULL,
	[Id_FeeChargedFor] [int] NULL,
	[Id_Account] [int] NULL,
	[Id_Class] [int] NULL,
	[Fee] [money] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_ClassFee] PRIMARY KEY CLUSTERED 
(
	[Id_ClassFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ClientInfo]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ClientInfo](
	[Name] [varchar](255) NULL,
	[SubName] [varchar](255) NULL,
	[Address] [varchar](255) NULL,
	[Contacts] [varchar](255) NULL,
	[Date] [varchar](255) NULL,
	[Font] [varchar](50) NULL,
	[FontSize] [varchar](50) NULL,
	[IsBold] [varchar](50) NULL,
	[M01] [varchar](50) NULL,
	[M02] [varchar](50) NULL,
	[M03] [varchar](50) NULL,
	[M04] [varchar](50) NULL,
	[M05] [varchar](50) NULL,
	[M06] [varchar](50) NULL,
	[M07] [varchar](50) NULL,
	[M08] [varchar](50) NULL,
	[M09] [varchar](50) NULL,
	[M10] [varchar](50) NULL,
	[Bank] [varchar](255) NULL,
	[BankAccount] [varchar](255) NULL,
	[VoucherFooter] [varchar](255) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ClientPics]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClientPics](
	[Id_Pic] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Pic] [image] NULL,
	[bytes] [int] NULL,
 CONSTRAINT [PK_ClientPics] PRIMARY KEY CLUSTERED 
(
	[Id_Pic] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Copy]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Copy](
	[Copy] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Crt_Provisional]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Crt_Provisional](
	[Id_Crt_Provisional] [int] IDENTITY(1,1) NOT NULL,
	[Id_Student] [int] NULL,
	[CNo] [nvarchar](50) NULL,
	[Board] [nvarchar](50) NULL,
	[Exam] [nvarchar](50) NULL,
	[Group] [nvarchar](50) NULL,
	[Year] [nvarchar](50) NULL,
	[RollNo] [nvarchar](50) NULL,
	[Grade] [nvarchar](50) NULL,
	[IssueDate] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Crt_TWIMC]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Crt_TWIMC](
	[Id_Crt_TWIMC] [int] IDENTITY(1,1) NOT NULL,
	[Id_Student] [int] NULL,
	[CNo] [nvarchar](50) NULL,
	[IssueDate] [datetime] NULL,
	[Remarks] [nvarchar](255) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Data]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Data](
	[Category] [nvarchar](255) NULL,
	[Short] [varchar](50) NULL,
	[CLASS] [nvarchar](255) NULL,
	[Sec] [nvarchar](255) NULL,
	[GRNo] [int] NULL,
	[GRNo_Fake] [int] NULL,
	[Name] [nvarchar](255) NULL,
	[Sex] [nvarchar](255) NULL,
	[Father] [nvarchar](255) NULL,
	[Profession] [nvarchar](255) NULL,
	[Contact1] [nvarchar](255) NULL,
	[Contact2] [nvarchar](255) NULL,
	[Contact3] [nvarchar](255) NULL,
	[NICNo] [nvarchar](255) NULL,
	[Area] [nvarchar](255) NULL,
	[Address] [nvarchar](255) NULL,
	[DOB] [datetime] NULL,
	[PlaceOfBirth] [nvarchar](255) NULL,
	[LastSchool] [nvarchar](255) NULL,
	[Nationality] [nvarchar](255) NULL,
	[Religion] [nvarchar](255) NULL,
	[House] [nvarchar](255) NULL,
	[Annual Charges] [money] NULL,
	[Tuition Fee] [money] NULL,
	[Lab Fee] [money] NULL,
	[Balance] [money] NULL,
	[Remark] [nvarchar](255) NULL,
	[F26] [nvarchar](255) NULL,
	[F27] [nvarchar](255) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DayAttendance]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DayAttendance](
	[Id_DayAttendance] [int] IDENTITY(1,1) NOT NULL,
	[Id_DayEvent] [int] NULL,
	[Id_StudentSec] [int] NULL,
	[Id_AttendanceStatus] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DayEvent]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DayEvent](
	[Id_DayEvent] [int] IDENTITY(1,1) NOT NULL,
	[Id_Calendar] [int] NULL,
	[Id_EventTitle] [int] NULL,
	[Date] [datetime] NULL,
	[IsHoliday] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DeleteLog]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DeleteLog](
	[ID_DeleteLog] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NULL,
	[TableName] [varchar](255) NULL,
	[ID] [int] NULL,
	[Remarks] [varchar](255) NULL,
	[OnDate] [datetime] NULL,
 CONSTRAINT [PK_DeleteLog] PRIMARY KEY CLUSTERED 
(
	[ID_DeleteLog] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Department]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[Id_Department] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaDepartment_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_Department] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Designation]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Designation](
	[Id_Designation] [int] IDENTITY(1,1) NOT NULL,
	[ID_Department] [int] NULL,
	[ID_Parent] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaDesignation_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_Designation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Document]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Document](
	[ID_Document] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Document] PRIMARY KEY CLUSTERED 
(
	[ID_Document] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Employee]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[Id_Employee] [int] IDENTITY(1,1) NOT NULL,
	[Id_Qualification] [int] NULL,
	[ID_Area] [int] NULL,
	[ECode] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[IsMale] [bit] NOT NULL,
	[IsMarried] [bit] NOT NULL,
	[FatherOrHusband] [nvarchar](255) NULL,
	[NICNo] [nvarchar](50) NULL,
	[NICExpiredOn] [datetime] NULL,
	[DOB] [datetime] NULL,
	[Contact1] [nvarchar](50) NULL,
	[Contact2] [nvarchar](50) NULL,
	[Address] [nvarchar](255) NULL,
	[BankAccount] [nvarchar](50) NULL,
	[email] [nvarchar](255) NULL,
	[OnProbation] [bit] NOT NULL,
	[DOJ] [datetime] NULL,
	[DOP] [datetime] NULL,
	[IsLeft] [bit] NOT NULL,
	[DOL] [datetime] NULL,
	[CauseOfLeaving] [nvarchar](255) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployee_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_Employee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeAttendance]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeAttendance](
	[Id_EmployeeAttendance] [int] NOT NULL,
	[Id_Employee] [int] NULL,
	[Id_AttendanceStatus] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeExperience]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeExperience](
	[ID_EmployeeExperience] [int] IDENTITY(1,1) NOT NULL,
	[ID_Employee] [int] NULL,
	[WorkedAs] [nvarchar](255) NULL,
	[Duration] [nvarchar](255) NULL,
	[Organization] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeExperience_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_EmployeeExperience] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeIDCard]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeIDCard](
	[Id_EmployeeIDCard] [int] IDENTITY(1,1) NOT NULL,
	[Id_EmployeeJob] [int] NULL,
	[IssueDate] [datetime] NULL,
	[ExpiryDate] [datetime] NULL,
	[IsExpired] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeIDCard_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_EmployeeIDCard] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeJob]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeJob](
	[Id_EmployeeJob] [int] IDENTITY(1,1) NOT NULL,
	[ID_Employee] [int] NULL,
	[ID_Designation] [int] NULL,
	[ID_PayScale] [int] NULL,
	[FromDate] [datetime] NULL,
	[IsActive] [bit] NOT NULL,
	[TaxDeduction] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeJob_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_EmployeeJob] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeLeave]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeLeave](
	[Id_EmployeeLeave] [int] IDENTITY(1,1) NOT NULL,
	[Id_EmployeeJob] [int] NULL,
	[Id_LeaveType] [int] NULL,
	[Id_LeaveTime] [int] NULL,
	[IsEarned] [bit] NOT NULL,
	[Days] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeLeave_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_EmployeeLeave] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeSalary]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeSalary](
	[Id_EmployeeSalary] [int] IDENTITY(1,1) NOT NULL,
	[Id_EmployeeJob] [int] NULL,
	[Id_Account] [int] NULL,
	[Amount] [money] NULL,
	[IsEarning] [bit] NOT NULL,
	[IsPercent] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeSalary_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_EmployeeSalary] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeSkill]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeSkill](
	[ID_EmployeeSkill] [int] IDENTITY(1,1) NOT NULL,
	[ID_Employee] [int] NULL,
	[ID_Skill] [int] NULL,
	[Details] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaEmployeeSkill_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_EmployeeSkill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EventTitle]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EventTitle](
	[Id_EventTitle] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Color] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Exam]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Exam](
	[Id_Exam] [int] IDENTITY(1,1) NOT NULL,
	[Id_ExamTitle] [int] NULL,
	[Id_Session] [int] NULL,
	[Remarks] [nvarchar](50) NULL,
	[SideNote] [varchar](255) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Exam] PRIMARY KEY CLUSTERED 
(
	[Id_Exam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ExamTitle]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ExamTitle](
	[Id_ExamTitle] [int] IDENTITY(1,1) NOT NULL,
	[Id_ExamType] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[IsActive] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_ExamTitle] PRIMARY KEY CLUSTERED 
(
	[Id_ExamTitle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ExamType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ExamType](
	[Id_ExamType] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Level] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeeChargedFor]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeeChargedFor](
	[Id_FeeChargedFor] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[OrderNo] [int] NULL,
	[Type] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_FeeChargedFor] PRIMARY KEY CLUSTERED 
(
	[Id_FeeChargedFor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeePeriod]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeePeriod](
	[Id_FeePeriod] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[From] [datetime] NULL,
	[To] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_FeePeriod] PRIMARY KEY CLUSTERED 
(
	[Id_FeePeriod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FinancialYear]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FinancialYear](
	[Id_FinancialYear] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[FromDate] [datetime] NULL,
	[ToDate] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Guardian]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Guardian](
	[Id_Guardian] [int] IDENTITY(1,1) NOT NULL,
	[Id_Profession] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[NICNo] [nvarchar](50) NULL,
	[Contact1] [nvarchar](50) NULL,
	[Contact2] [nvarchar](50) NULL,
	[Contact3] [nvarchar](50) NULL,
	[Address] [nvarchar](255) NULL,
	[id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Id_Area] [int] NULL,
 CONSTRAINT [PK_Guardian] PRIMARY KEY CLUSTERED 
(
	[Id_Guardian] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[House]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[House](
	[Id_House] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[IDCard]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IDCard](
	[Id_IDCard] [int] IDENTITY(1,1) NOT NULL,
	[Id_StudentSec] [int] NULL,
	[IssueDate] [datetime] NULL,
	[ValidUpto] [datetime] NULL,
	[IsExpired] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LastSchool]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LastSchool](
	[Id_LastSchool] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LeaveLedger]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LeaveLedger](
	[Id_LeaveLedger] [int] IDENTITY(1,1) NOT NULL,
	[Id_SalarySlip] [int] NULL,
	[Id_LeaveType] [int] NULL,
	[Id_LeaveTime] [int] NULL,
	[IsEarned] [bit] NOT NULL,
	[Days] [int] NULL,
	[IsDebit] [bit] NOT NULL,
	[ExpiryDate] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsCashed] [bit] NOT NULL,
 CONSTRAINT [aaaaaLeaveLedger_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_LeaveLedger] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LeaveTime]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LeaveTime](
	[Id_LeaveTime] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LeaveType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LeaveType](
	[Id_LeaveType] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LibraryCard]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LibraryCard](
	[ID_LibraryCard] [int] IDENTITY(1,1) NOT NULL,
	[ID_LibraryMemberType] [int] NULL,
	[ID_Parent] [int] NULL,
	[IssueDate] [datetime] NULL,
	[ExpiredOn] [datetime] NULL,
	[Remarks] [nvarchar](255) NULL,
	[IsActive] [bit] NOT NULL,
	[MaxBooks] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaLibraryCard_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_LibraryCard] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LibraryDefaults]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LibraryDefaults](
	[StudentLateFinePerDay] [money] NULL,
	[StudentAllowedDays] [int] NULL,
	[StudentMaxBooks] [int] NULL,
	[StaffLateFinePerDay] [money] NULL,
	[StaffAllowedDays] [int] NULL,
	[StaffMaxBooks] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LibraryMember]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LibraryMember](
	[ID_LibraryMember] [int] IDENTITY(1,1) NOT NULL,
	[MCode] [int] NULL,
	[Name] [nvarchar](255) NULL,
	[Address] [nvarchar](255) NULL,
	[ContactNo] [nvarchar](255) NULL,
	[OtherInfo] [nvarchar](255) NULL,
	[DOJ] [datetime] NULL,
	[DOB] [datetime] NULL,
	[IsActive] [bit] NOT NULL,
 CONSTRAINT [aaaaaLibraryMember_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_LibraryMember] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LibraryMemberType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LibraryMemberType](
	[ID_LibraryMemberType] [int] NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Module]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Module](
	[ID_Module] [int] NOT NULL,
	[Code] [int] NULL,
	[Name] [varchar](50) NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Nationality]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nationality](
	[Id_Nationality] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Notice]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notice](
	[Id_Notice] [int] IDENTITY(1,1) NOT NULL,
	[Date] [datetime] NULL,
	[Message] [ntext] NULL,
	[Remarks] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Notice] PRIMARY KEY CLUSTERED 
(
	[Id_Notice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ObtainedMarks]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ObtainedMarks](
	[Id_ObtainedMarks] [int] IDENTITY(1,1) NOT NULL,
	[Id_ResultCard] [int] NULL,
	[Marks] [real] NULL,
	[SubMarks] [real] NULL,
	[Id_Test] [int] NULL,
	[IsPromoted] [bit] NULL,
	[Attempted] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_ObtainedMarks] PRIMARY KEY CLUSTERED 
(
	[Id_ObtainedMarks] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaidSlip]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaidSlip](
	[Id_PaidSlip] [int] IDENTITY(1,1) NOT NULL,
	[Id_Slip] [int] NULL,
	[Id_Transaction] [int] NULL,
	[Remarks] [nvarchar](100) NULL,
	[cancelled] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_PaidSlip] PRIMARY KEY CLUSTERED 
(
	[Id_PaidSlip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentChunk]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentChunk](
	[Id_PaymentChunk] [int] IDENTITY(1,1) NOT NULL,
	[Id_SlipPayment] [int] NULL,
	[Id_SlipFee] [int] NULL,
	[Amount] [money] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_PaymentChunk] PRIMARY KEY CLUSTERED 
(
	[Id_PaymentChunk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PayScale]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PayScale](
	[Id_PayScale] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Level] [int] NULL,
	[ProbationMonths] [int] NULL,
	[AnnualIncrementRate] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaPayScale_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_PayScale] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PayScaleLeave]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PayScaleLeave](
	[Id_PayScaleLeave] [int] IDENTITY(1,1) NOT NULL,
	[Id_PayScale] [int] NULL,
	[Id_LeaveType] [int] NULL,
	[Id_LeaveTime] [int] NULL,
	[IsEarned] [bit] NOT NULL,
	[Days] [int] NULL,
	[ProbationDays] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaPayScaleLeave_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_PayScaleLeave] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PayScaleSalary]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PayScaleSalary](
	[Id_PayScaleSalary] [int] IDENTITY(1,1) NOT NULL,
	[Id_PayScale] [int] NULL,
	[Id_Account] [int] NULL,
	[Amount] [money] NULL,
	[ProbationAmount] [money] NULL,
	[IsEarning] [bit] NOT NULL,
	[IsMain] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsPercent] [bit] NOT NULL,
 CONSTRAINT [aaaaaPayScaleSalary_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_PayScaleSalary] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Period]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Period](
	[ID_Period] [int] IDENTITY(1,1) NOT NULL,
	[ID_PeriodTime] [int] NULL,
	[ID_Sec] [int] NULL,
	[ID_Subject] [int] NULL,
	[ID_Teacher] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Locked] [bit] NOT NULL,
 CONSTRAINT [aaaaaPeriod_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_Period] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PeriodsPerWeek]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PeriodsPerWeek](
	[ID_PeriodsPerWeek] [int] IDENTITY(1,1) NOT NULL,
	[ID_Subject] [int] NULL,
	[Periods] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaPeriodsPerWeek_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_PeriodsPerWeek] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PeriodTime]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PeriodTime](
	[ID_PeriodTime] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NULL,
	[TimeStart] [datetime] NULL,
	[TimeEnd] [datetime] NULL,
	[DayNo] [int] NULL,
	[TeacherIsRequired] [bit] NOT NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaPeriodTime_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_PeriodTime] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PlaceOfBirth]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PlaceOfBirth](
	[Id_PlaceOfBirth] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[ID_USER] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Profession]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Profession](
	[ID_Profession] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
 CONSTRAINT [PK_Profession_1] PRIMARY KEY CLUSTERED 
(
	[ID_Profession] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Qualification]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Qualification](
	[Id_Qualification] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaQualification_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_Qualification] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Religion]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Religion](
	[Id_Religion] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Reminder]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Reminder](
	[ID_Reminder] [int] IDENTITY(1,1) NOT NULL,
	[Message] [varchar](255) NOT NULL,
	[Date] [datetime] NULL,
	[RemindTime] [datetime] NULL,
	[IsPrivate] [bit] NOT NULL,
	[Finished] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Reminder] PRIMARY KEY CLUSTERED 
(
	[ID_Reminder] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ResultCard]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ResultCard](
	[Id_ResultCard] [int] IDENTITY(1,1) NOT NULL,
	[Id_StudentSec] [int] NULL,
	[Remarks] [varchar](255) NULL,
	[Id_Exam] [int] NULL,
	[Rank] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SalaryPeriod]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalaryPeriod](
	[Id_SalaryPeriod] [int] IDENTITY(1,1) NOT NULL,
	[SalaryMonth] [datetime] NULL,
	[WorkingDays] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaSalaryPeriod_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_SalaryPeriod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SalarySlip]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SalarySlip](
	[ID_SalarySlip] [int] IDENTITY(1,1) NOT NULL,
	[ID_SalaryPeriod] [int] NULL,
	[ID_EmployeeJob] [int] NULL,
	[WorkingDays] [int] NULL,
	[Absentee] [int] NULL,
	[IssueDate] [datetime] NULL,
	[Remarks] [varchar](255) NULL,
	[Cancelled] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsGenerated] [bit] NOT NULL,
	[AbsenteeDeduction] [money] NULL,
	[BasicSalary] [money] NULL,
	[Id_Voucher] [int] NULL,
	[Arrears] [money] NULL,
 CONSTRAINT [aaaaaSalarySlip_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_SalarySlip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SalarySlipDetail]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalarySlipDetail](
	[Id_SalarySlipDetail] [int] IDENTITY(1,1) NOT NULL,
	[Id_SalarySlip] [int] NULL,
	[Id_Account] [int] NULL,
	[Amount] [money] NULL,
	[IsEarning] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsMain] [bit] NOT NULL,
 CONSTRAINT [aaaaaSalarySlipDetail_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_SalarySlipDetail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SalarySlipPayment]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalarySlipPayment](
	[Id_SalarySlipPayment] [int] IDENTITY(1,1) NOT NULL,
	[Id_SalarySlip] [int] NULL,
	[OnDate] [datetime] NULL,
	[Id_CreditAccount] [int] NULL,
	[Amount] [money] NULL,
	[Remarks] [nvarchar](255) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[IsBankTransfer] [bit] NOT NULL,
 CONSTRAINT [aaaaaSalarySlipPayment_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_SalarySlipPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sec]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sec](
	[Id_Sec] [int] IDENTITY(1,1) NOT NULL,
	[Id_Class] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[IsDeleted] [bit] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_Sec] PRIMARY KEY CLUSTERED 
(
	[Id_Sec] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SessionInfo]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SessionInfo](
	[Id_Session] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[From] [datetime] NULL,
	[To] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaSessionInfo_PK] PRIMARY KEY NONCLUSTERED 
(
	[Id_Session] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Skill]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skill](
	[ID_Skill] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaSkill_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_Skill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Slip]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Slip](
	[ID_Slip] [int] IDENTITY(1,1) NOT NULL,
	[ID_FeePeriod] [int] NULL,
	[Id_StudentSec] [int] NULL,
	[ID_Student] [int] NULL,
	[DocRef] [nvarchar](50) NULL,
	[Remarks] [varchar](255) NULL,
	[IssueDate] [datetime] NULL,
	[DueDate] [datetime] NULL,
	[ValidUpto] [datetime] NULL,
	[Cancelled] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[LateFine] [money] NULL,
	[IsInstallment] [bit] NOT NULL,
	[InstallmentAmount] [money] NULL,
	[IsPerDayLateFine] [bit] NOT NULL,
	[ID_Voucher] [int] NULL,
 CONSTRAINT [PK_Slip] PRIMARY KEY CLUSTERED 
(
	[ID_Slip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SlipFee]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SlipFee](
	[Id_SlipFee] [int] IDENTITY(1,1) NOT NULL,
	[Id_Slip] [int] NULL,
	[Id_FeeChargedFor] [int] NULL,
	[Id_Account] [int] NULL,
	[Fee] [money] NULL,
	[Concession] [money] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_SlipFee] PRIMARY KEY CLUSTERED 
(
	[Id_SlipFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SlipPayment]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SlipPayment](
	[Id_SlipPayment] [int] IDENTITY(1,1) NOT NULL,
	[Id_Slip] [int] NULL,
	[OnDate] [datetime] NULL,
	[Id_DebitAccount] [int] NULL,
	[Amount] [money] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Remarks] [nvarchar](255) NULL,
	[ID_Voucher] [int] NULL,
 CONSTRAINT [PK_SlipPayment] PRIMARY KEY CLUSTERED 
(
	[Id_SlipPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SMS]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SMS](
	[ID_SMS] [int] IDENTITY(1,1) NOT NULL,
	[Message] [varchar](255) NULL,
	[ContactNo] [varchar](50) NULL,
	[IsSent] [bit] NULL,
	[SentTime] [smalldatetime] NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
 CONSTRAINT [PK_SMS] PRIMARY KEY CLUSTERED 
(
	[ID_SMS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Student](
	[ID_Student] [int] IDENTITY(1,1) NOT NULL,
	[ID_Sec] [int] NULL,
	[Id_Guardian] [int] NULL,
	[Id_Parent] [int] NULL,
	[Id_PlaceOfBirth] [int] NULL,
	[Id_LastSchool] [int] NULL,
	[Id_Nationality] [int] NULL,
	[Id_Religion] [int] NULL,
	[Id_House] [int] NULL,
	[RegNo] [int] NULL,
	[RegDate] [datetime] NULL,
	[IsAdmissioned] [bit] NOT NULL,
	[GRNo] [int] NULL,
	[Name] [varchar](255) NULL,
	[IsMale] [bit] NOT NULL,
	[DOB] [smalldatetime] NULL,
	[DOA] [smalldatetime] NULL,
	[DOL] [smalldatetime] NULL,
	[IsLeftSchool] [bit] NOT NULL,
	[CauseOfRemoval] [varchar](255) NULL,
	[DiscountPercentage] [money] NULL,
	[DiscountReason] [varchar](255) NULL,
	[Freeze] [bit] NOT NULL,
	[Boarding] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
	[FakeGRNo] [int] NULL,
	[IsFixedLateFine] [bit] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[ID_Student] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StudentDocument]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentDocument](
	[Id_StudentDocument] [int] IDENTITY(1,1) NOT NULL,
	[Id_Student] [int] NULL,
	[Id_Document] [int] NULL,
	[IsSubmit] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_StudentDocument] PRIMARY KEY CLUSTERED 
(
	[Id_StudentDocument] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StudentFee]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentFee](
	[Id_StudentFee] [int] IDENTITY(1,1) NOT NULL,
	[Id_Student] [int] NULL,
	[Id_FeeChargedFor] [int] NULL,
	[Id_Account] [int] NULL,
	[Fee] [smallmoney] NULL,
	[Discount] [smallmoney] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_StudentFee] PRIMARY KEY CLUSTERED 
(
	[Id_StudentFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StudentRemarks]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentRemarks](
	[Id_StudentRemarks] [int] IDENTITY(1,1) NOT NULL,
	[Id_Student] [int] NULL,
	[Remarks] [nvarchar](255) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_StudentRemarks] PRIMARY KEY CLUSTERED 
(
	[Id_StudentRemarks] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StudentSec]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentSec](
	[Id_StudentSec] [int] IDENTITY(1,1) NOT NULL,
	[ID_Sec] [int] NULL,
	[ID_Student] [int] NULL,
	[TransferDate] [datetime] NULL,
	[ToDate] [datetime] NULL,
	[Id_Session] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_StudentSec] PRIMARY KEY CLUSTERED 
(
	[Id_StudentSec] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subject]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[Id_Subject] [int] IDENTITY(1,1) NOT NULL,
	[Id_Class] [int] NULL,
	[Id_SubjectTitle] [int] NULL,
	[IsExtraActivity] [bit] NOT NULL,
	[IsActive] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SubjectTitle]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SubjectTitle](
	[Id_SubjectTitle] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[short] [varchar](50) NULL,
	[Color] [int] NULL,
 CONSTRAINT [PK_SubjectTitle] PRIMARY KEY CLUSTERED 
(
	[Id_SubjectTitle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Test]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[Id_Test] [int] IDENTITY(1,1) NOT NULL,
	[Id_Subject] [int] NULL,
	[MaxMarks] [real] NULL,
	[PassingMarks] [real] NULL,
	[MonthlyTestsMarks] [int] NULL,
	[Id_Exam] [int] NULL,
	[date] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TransferCertificate]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransferCertificate](
	[Id_TransferCertificate] [int] IDENTITY(1,1) NOT NULL,
	[Id_StudentSec] [int] NULL,
	[IssueDate] [datetime] NULL,
	[Conduct] [nvarchar](50) NULL,
	[Progress] [nvarchar](50) NULL,
	[TCNo] [int] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[MidTermGrade] [nvarchar](50) NULL,
	[MidTermDate] [datetime] NULL,
	[MidTermResult] [nvarchar](50) NULL,
	[FinalTermGrade] [nvarchar](50) NULL,
	[FinalTermDate] [datetime] NULL,
	[FinalTermResult] [nvarchar](50) NULL,
	[Remarks] [nvarchar](200) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Transport]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Transport](
	[ID_Transport] [int] NOT NULL,
	[DriverName] [varchar](50) NULL,
	[DriverNICNo] [varchar](50) NULL,
	[LicenceNumber] [varchar](50) NULL,
	[FatherName] [varchar](50) NULL,
	[Owner] [varchar](50) NULL,
	[Address] [varchar](255) NULL,
	[Contact1] [varchar](50) NULL,
	[Contact2] [varchar](50) NULL,
	[ID_TransportType] [int] NULL,
	[VehicleNumber] [varchar](50) NULL,
	[ChassesNumber] [varchar](50) NULL,
	[EngineNumber] [varchar](50) NULL,
	[Seats] [int] NULL,
	[DOJ] [smalldatetime] NULL,
	[DOL] [smalldatetime] NULL,
	[IsTerminated] [bit] NULL,
	[Id_User] [int] NULL,
	[UserTime] [smalldatetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TransportArea]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransportArea](
	[ID_TransportArea] [int] NOT NULL,
	[ID_Transport] [int] NULL,
	[ID_Area] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TransportCardStudent]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransportCardStudent](
	[ID_TransportCardStudent] [int] NOT NULL,
	[ID_Transport] [int] NULL,
	[CardNo] [int] NULL,
	[IssueDate] [smalldatetime] NULL,
	[ExpiredOn] [smalldatetime] NULL,
	[GRNo] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL,
	[IsActive] [bit] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TransportType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TransportType](
	[ID_TransportType] [int] NOT NULL,
	[Name] [varchar](50) NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id_User] [int] NOT NULL,
	[UserID] [nvarchar](50) NULL,
	[PassWord] [nvarchar](50) NULL,
	[Cancelled] [bit] NOT NULL,
	[AdminRights] [bit] NOT NULL,
	[Id_DataUser] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserRights]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRights](
	[ID_UserRights] [int] NOT NULL,
	[UserID] [int] NULL,
	[ID_Module] [int] NULL,
	[AddRight] [bit] NULL,
	[EditRight] [bit] NULL,
	[PrintRight] [bit] NULL,
	[DeleteRight] [bigint] NULL,
	[ID_User] [int] NULL,
	[UserTime] [smalldatetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[ID_Vehicle] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NULL,
	[VNumber] [nvarchar](255) NULL,
	[Cancelled] [int] NULL,
	[ID_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [aaaaaVehicle_PK] PRIMARY KEY NONCLUSTERED 
(
	[ID_Vehicle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Voucher](
	[Id_Voucher] [int] IDENTITY(1,1) NOT NULL,
	[Id_VoucherType] [int] NULL,
	[ID_FinancialYear] [int] NULL,
	[Code] [int] NULL,
	[OnDate] [datetime] NULL,
	[Narration] [varchar](max) NULL,
	[IsCheque] [bit] NOT NULL,
	[Id_Bank] [int] NULL,
	[ID_ChequeType] [int] NULL,
	[ChqNo] [nvarchar](50) NULL,
	[ChqDate] [datetime] NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[Posted] [bit] NOT NULL,
 CONSTRAINT [PK_Voucher] PRIMARY KEY CLUSTERED 
(
	[Id_Voucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VoucherDetail]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VoucherDetail](
	[ID_VoucherDetail] [int] IDENTITY(1,1) NOT NULL,
	[Id_Voucher] [int] NULL,
	[Id_YearAccount] [int] NULL,
	[Amount] [money] NULL,
	[IsDebit] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
 CONSTRAINT [PK_VoucherDetail] PRIMARY KEY CLUSTERED 
(
	[ID_VoucherDetail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[VoucherType]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VoucherType](
	[Id_VoucherType] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Short] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL,
	[OrderNo] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[YearAccount]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[YearAccount](
	[Id_YearAccount] [int] IDENTITY(1,1) NOT NULL,
	[Id_FinancialYear] [int] NULL,
	[Id_Account] [int] NULL,
	[OpeningBal] [money] NULL,
	[IsDebit] [bit] NOT NULL,
	[Id_User] [int] NULL,
	[UserTime] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[V_SlipFee]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_SlipFee]
AS
(SELECT     SlipFee.ID_SlipFee AS UID, Slip.ID_Student, Slip.Id_StudentSec, Slip.ID_Slip, Slip.IssueDate AS [Date], SlipFee.Id_FeeChargedFor, 
                      FeeChargedFor.Name AS FeeChargedFor, SlipFee.Id_Account, Account.Name AS Account, SlipFee.Fee AS Credit, 0 AS Debit, Slip.Cancelled, 
                      FeeChargedFor.OrderNo, SlipFee.Concession
FROM         ((Slip INNER JOIN
                      SlipFee ON Slip.ID_Slip = SlipFee.Id_Slip) INNER JOIN
                      FeeChargedFor ON SlipFee.Id_FeeChargedFor = FeeChargedFor.Id_FeeChargedFor) INNER JOIN
                      Account ON SlipFee.Id_Account = Account.Id_Account)
UNION
(SELECT     PaymentChunk.Id_PaymentChunk AS UID, Slip.ID_Student, Slip.Id_StudentSec, Slip.ID_Slip, SlipPayment.OnDate AS [Date], 
                        SlipFee.Id_FeeChargedFor, FeeChargedFor.Name AS FeeChargedFor, SlipFee.Id_Account, Account.Name AS Account, 0 AS Credit, 
                        PaymentChunk.Amount AS Debit, Slip.Cancelled, FeeChargedFor.OrderNo, SlipFee.Concession
 FROM         ((Slip INNER JOIN
                        ((SlipFee INNER JOIN
                        FeeChargedFor ON SlipFee.Id_FeeChargedFor = FeeChargedFor.Id_FeeChargedFor) INNER JOIN
                        Account ON SlipFee.Id_Account = Account.Id_Account) ON Slip.ID_Slip = SlipFee.Id_Slip) INNER JOIN
                        PaymentChunk ON SlipFee.Id_SlipFee = PaymentChunk.Id_SlipFee) INNER JOIN
                        SlipPayment ON PaymentChunk.Id_SlipPayment = SlipPayment.Id_SlipPayment)

GO
/****** Object:  View [dbo].[V_SlipFeeLedger]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_SlipFeeLedger]
AS
(SELECT     SlipFee.Id_SlipFee AS UID, Slip.ID_Student, Slip.ID_Slip, Slip.IssueDate AS Date, SlipFee.Fee AS Credit, 0 AS Debit
FROM         Slip INNER JOIN
                      SlipFee ON Slip.ID_Slip = SlipFee.Id_Slip)
UNION
(SELECT     SlipPayment.ID_SlipPayment AS UID, Slip.ID_Student, Slip.ID_Slip, SlipPayment.OnDate AS Date, 0 AS Credit, SlipPayment.Amount AS Debit
 FROM         Slip INNER JOIN
                        SlipPayment ON Slip.ID_Slip = SlipPayment.Id_Slip)

GO
/****** Object:  View [dbo].[V_StudentFeeLedger]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_StudentFeeLedger]
AS
(SELECT     Student.ID_Student, Student.GRNo, Student.Name AS Student, Student.IsMale, Guardian.Name AS Guardian, 
                      Class.Name + ' (' + [Sec].Name + ')' AS ClassSec, FeePeriod.Name AS FeePeriod, FeePeriod.[From], Slip.IssueDate AS [Date], 
                      'Fee Charged (' + CONVERT(varchar(6), Slip.Id_Slip) + ' )' AS [Type], Account.Name + ' ( ' + FeeChargedFor.Name + ' )' AS Details, 0 AS Debit, 
                      SlipFee.Fee AS Credit
FROM         (FeePeriod INNER JOIN
                      (Slip INNER JOIN
                      ((SlipFee INNER JOIN
                      Account ON SlipFee.Id_Account = Account.Id_Account) INNER JOIN
                      FeeChargedFor ON SlipFee.Id_FeeChargedFor = FeeChargedFor.Id_FeeChargedFor) ON Slip.ID_Slip = SlipFee.Id_Slip) ON 
                      FeePeriod.Id_FeePeriod = Slip.ID_FeePeriod) INNER JOIN
                      (Class INNER JOIN
                      ((Guardian INNER JOIN
                      Student ON Guardian.Id_Guardian = Student.Id_Parent) INNER JOIN
                      (Sec INNER JOIN
                      StudentSec ON [Sec].Id_Sec = StudentSec.ID_Sec) ON Student.ID_Student = StudentSec.ID_Student) ON Class.Id_Class = [Sec].Id_Class) ON 
                      Slip.Id_StudentSec = StudentSec.Id_StudentSec)
UNION
(SELECT     Student.ID_Student, Student.GRNo, Student.Name AS Student, Student.IsMale, Guardian.Name AS Guardian, 
                        Class.Name + ' (' + [Sec].Name + ')' AS ClassSec, FeePeriod.Name AS FeePeriod, FeePeriod.[From], SlipPayment.OnDate AS [Date], 
                        'Fee Paid (' + CONVERT(varchar(6), SlipPayment.Id_SlipPayment) + ' )' AS [Type], Account.Name AS Details, SlipPayment.Amount AS Debit, 
                        0 AS Credit
 FROM         (FeePeriod INNER JOIN
                        (Account INNER JOIN
                        (Slip INNER JOIN
                        SlipPayment ON Slip.ID_Slip = SlipPayment.Id_Slip) ON Account.Id_Account = SlipPayment.Id_DebitAccount) ON 
                        FeePeriod.Id_FeePeriod = Slip.ID_FeePeriod) INNER JOIN
                        (Class INNER JOIN
                        ((Guardian INNER JOIN
                        Student ON Guardian.Id_Guardian = Student.Id_Parent) INNER JOIN
                        (Sec INNER JOIN
                        StudentSec ON [Sec].Id_Sec = StudentSec.ID_Sec) ON Student.ID_Student = StudentSec.ID_Student) ON Class.Id_Class = [Sec].Id_Class) ON 
                        Slip.Id_StudentSec = StudentSec.Id_StudentSec);

GO
/****** Object:  View [dbo].[V_Transactions]    Script Date: 5/18/2019 3:19:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_Transactions]
AS
SELECT     dbo.YearAccount.Id_YearAccount AS UID, 0 AS Id_Voucher, dbo.FinancialYear.Name AS FinancialYear, dbo.FinancialYear.FromDate AS OnDate, 
                      'Opb-' + CONVERT(varchar(10), dbo.YearAccount.Id_YearAccount) AS VNo, 'Account Opening Bal in ' + dbo.FinancialYear.Name AS Narration, 
                      CASE YearAccount.IsDebit WHEN 1 THEN YearAccount.OpeningBal ELSE 0 END AS Debit, 
                      CASE YearAccount.IsDebit WHEN 0 THEN YearAccount.OpeningBal ELSE 0 END AS Credit, '-' AS ChqNo, '-' AS ChqDate, 
                      dbo.AccountType.Name AS AccType, dbo.AccountType.OrderNo AS AccTypeO, dbo.AccountGroup.Name AS AccGroup, 
                      dbo.AccountSubGroup.Name AS AccSubGroup, dbo.Account.Name AS AccName, 
                      dbo.AccountType.Code + '-' + dbo.AccountGroup.Code + '-' + dbo.AccountSubGroup.Code + '-' + dbo.Account.Code AS AccCode, 0 AS Posted
FROM         dbo.FinancialYear INNER JOIN
                      dbo.AccountType INNER JOIN
                      dbo.AccountGroup INNER JOIN
                      dbo.Account INNER JOIN
                      dbo.AccountSubGroup ON dbo.Account.Id_AccountSubGroup = dbo.AccountSubGroup.Id_AccountSubGroup ON 
                      dbo.AccountGroup.Id_AccountGroup = dbo.AccountSubGroup.Id_AccountGroup ON 
                      dbo.AccountType.Id_AccountType = dbo.AccountGroup.Id_AccountType INNER JOIN
                      dbo.YearAccount ON dbo.Account.Id_Account = dbo.YearAccount.Id_Account ON 
                      dbo.FinancialYear.Id_FinancialYear = dbo.YearAccount.Id_FinancialYear
WHERE     (dbo.YearAccount.OpeningBal <> 0)
UNION
SELECT     dbo.VoucherDetail.ID_VoucherDetail AS UID, dbo.Voucher.Id_Voucher, FinancialYear_1.Name AS FinancialYear, dbo.Voucher.OnDate, 
                      dbo.VoucherType.Short + '-' + CONVERT(varchar(10), dbo.Voucher.Code) AS VNo, dbo.Voucher.Narration, 
                      CASE VoucherDetail.IsDebit WHEN 1 THEN VoucherDetail.Amount ELSE 0 END AS Debit, 
                      CASE VoucherDetail.IsDebit WHEN 0 THEN VoucherDetail.Amount ELSE 0 END AS Credit, CASE dbo.Voucher.IsCheque WHEN NULL 
                      THEN '-' ELSE dbo.Voucher.ChqNo END AS ChqNo, CASE dbo.Voucher.IsCheque WHEN NULL THEN '-' ELSE CONVERT(varchar(11), 
                      dbo.Voucher.ChqDate, 105) END AS ChqDate, AccountType_1.Name AS AccType, AccountType_1.OrderNo AS AccTypeO, 
                      AccountGroup_1.Name AS AccGroup, AccountSubGroup_1.Name AS AccSubGroup, Account_1.Name AS AccName, 
                      AccountType_1.Code + '-' + AccountGroup_1.Code + '-' + AccountSubGroup_1.Code + '-' + Account_1.Code AS AccCode, 0 AS Posted
FROM         dbo.YearAccount AS YearAccount_1 INNER JOIN
                      dbo.Account AS Account_1 INNER JOIN
                      dbo.AccountSubGroup AS AccountSubGroup_1 ON Account_1.Id_AccountSubGroup = AccountSubGroup_1.Id_AccountSubGroup ON 
                      YearAccount_1.Id_Account = Account_1.Id_Account INNER JOIN
                      dbo.FinancialYear AS FinancialYear_1 ON YearAccount_1.Id_FinancialYear = FinancialYear_1.Id_FinancialYear INNER JOIN
                      dbo.Voucher ON FinancialYear_1.Id_FinancialYear = dbo.Voucher.ID_FinancialYear INNER JOIN
                      dbo.AccountType AS AccountType_1 INNER JOIN
                      dbo.AccountGroup AS AccountGroup_1 ON AccountType_1.Id_AccountType = AccountGroup_1.Id_AccountType ON 
                      AccountSubGroup_1.Id_AccountGroup = AccountGroup_1.Id_AccountGroup INNER JOIN
                      dbo.VoucherDetail ON dbo.Voucher.Id_Voucher = dbo.VoucherDetail.Id_Voucher AND 
                      YearAccount_1.Id_YearAccount = dbo.VoucherDetail.Id_YearAccount INNER JOIN
                      dbo.VoucherType ON dbo.Voucher.Id_VoucherType = dbo.VoucherType.Id_VoucherType LEFT OUTER JOIN
                      dbo.ChequeType ON dbo.Voucher.ID_ChequeType = dbo.ChequeType.Id_ChequeType

GO
ALTER TABLE [dbo].[BookTransaction] ADD  DEFAULT ((0)) FOR [IsReturned]
GO
ALTER TABLE [dbo].[BookTransaction] ADD  DEFAULT ((0)) FOR [FineIsPaid]
GO
ALTER TABLE [dbo].[BookTransaction] ADD  DEFAULT ((0)) FOR [IsRated]
GO
ALTER TABLE [dbo].[DeleteLog] ADD  CONSTRAINT [DF__DeleteLog__OnDat__035179CE]  DEFAULT (getdate()) FOR [OnDate]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [Id_Qualification]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [IsMale]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [IsMarried]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [OnProbation]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [IsLeft]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[EmployeeIDCard] ADD  DEFAULT ((0)) FOR [Id_EmployeeJob]
GO
ALTER TABLE [dbo].[EmployeeIDCard] ADD  DEFAULT ((0)) FOR [IsExpired]
GO
ALTER TABLE [dbo].[EmployeeJob] ADD  DEFAULT ((0)) FOR [ID_Employee]
GO
ALTER TABLE [dbo].[EmployeeJob] ADD  DEFAULT ((0)) FOR [IsActive]
GO
ALTER TABLE [dbo].[EmployeeJob] ADD  DEFAULT ((0)) FOR [TaxDeduction]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [Id_EmployeeJob]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [Id_LeaveType]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [Id_LeaveTime]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [IsEarned]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [Days]
GO
ALTER TABLE [dbo].[EmployeeLeave] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[EmployeeSalary] ADD  DEFAULT ((0)) FOR [Id_EmployeeJob]
GO
ALTER TABLE [dbo].[EmployeeSalary] ADD  DEFAULT ((0)) FOR [Id_Account]
GO
ALTER TABLE [dbo].[EmployeeSalary] ADD  DEFAULT ((0)) FOR [Amount]
GO
ALTER TABLE [dbo].[EmployeeSalary] ADD  DEFAULT ((0)) FOR [IsEarning]
GO
ALTER TABLE [dbo].[EmployeeSalary] ADD  DEFAULT ((0)) FOR [IsPercent]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [Id_SalarySlip]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [Id_LeaveType]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [Id_LeaveTime]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [IsEarned]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [Days]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [IsDebit]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[LeaveLedger] ADD  DEFAULT ((0)) FOR [IsCashed]
GO
ALTER TABLE [dbo].[LibraryCard] ADD  DEFAULT ((0)) FOR [IsActive]
GO
ALTER TABLE [dbo].[LibraryMember] ADD  DEFAULT ((0)) FOR [IsActive]
GO
ALTER TABLE [dbo].[PayScale] ADD  DEFAULT ((0)) FOR [Level]
GO
ALTER TABLE [dbo].[PayScale] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [Id_PayScale]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [Id_LeaveType]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [Id_LeaveTime]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [IsEarned]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [Days]
GO
ALTER TABLE [dbo].[PayScaleLeave] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [Id_PayScale]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [Id_Account]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [Amount]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [IsEarning]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [IsMain]
GO
ALTER TABLE [dbo].[PayScaleSalary] ADD  DEFAULT ((0)) FOR [IsPercent]
GO
ALTER TABLE [dbo].[Period] ADD  DEFAULT ((0)) FOR [Locked]
GO
ALTER TABLE [dbo].[PeriodTime] ADD  DEFAULT ((0)) FOR [TeacherIsRequired]
GO
ALTER TABLE [dbo].[Qualification] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[SalaryPeriod] ADD  DEFAULT ((0)) FOR [WorkingDays]
GO
ALTER TABLE [dbo].[SalaryPeriod] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[SalarySlip] ADD  CONSTRAINT [DF__SalarySli__ID_Sa__1E6F845E]  DEFAULT ((0)) FOR [ID_SalaryPeriod]
GO
ALTER TABLE [dbo].[SalarySlip] ADD  CONSTRAINT [DF__SalarySli__ID_Em__1F63A897]  DEFAULT ((0)) FOR [ID_EmployeeJob]
GO
ALTER TABLE [dbo].[SalarySlip] ADD  CONSTRAINT [DF__SalarySli__Cance__2057CCD0]  DEFAULT ((0)) FOR [Cancelled]
GO
ALTER TABLE [dbo].[SalarySlip] ADD  CONSTRAINT [DF__SalarySli__IsGen__214BF109]  DEFAULT ((0)) FOR [IsGenerated]
GO
ALTER TABLE [dbo].[SalarySlipDetail] ADD  DEFAULT ((0)) FOR [Id_SalarySlip]
GO
ALTER TABLE [dbo].[SalarySlipDetail] ADD  DEFAULT ((0)) FOR [Id_Account]
GO
ALTER TABLE [dbo].[SalarySlipDetail] ADD  DEFAULT ((0)) FOR [Amount]
GO
ALTER TABLE [dbo].[SalarySlipDetail] ADD  DEFAULT ((0)) FOR [IsEarning]
GO
ALTER TABLE [dbo].[SalarySlipDetail] ADD  DEFAULT ((0)) FOR [IsMain]
GO
ALTER TABLE [dbo].[SalarySlipPayment] ADD  DEFAULT ((0)) FOR [Id_SalarySlip]
GO
ALTER TABLE [dbo].[SalarySlipPayment] ADD  DEFAULT ((0)) FOR [Id_CreditAccount]
GO
ALTER TABLE [dbo].[SalarySlipPayment] ADD  DEFAULT ((0)) FOR [Amount]
GO
ALTER TABLE [dbo].[SalarySlipPayment] ADD  DEFAULT ((0)) FOR [Id_User]
GO
ALTER TABLE [dbo].[SalarySlipPayment] ADD  DEFAULT ((0)) FOR [IsBankTransfer]
GO
USE [master]
GO
ALTER DATABASE [Main] SET  READ_WRITE 
GO
